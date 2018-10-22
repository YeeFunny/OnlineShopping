package com.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Card;
import com.dto.User;
import com.exception.DatabaseException;

@Repository
public class CardRepositoryImpl implements CardRepository{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Card getCardById(int cardId) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Card> cq = cb.createQuery(Card.class);
		Root<Card> root = cq.from(Card.class);
		cq.where(cb.equal(root.get("cardId"), cardId));
		Card card = session.createQuery(cq).uniqueResult();
		session.close();
		return card;
	}

	@Override
	public List<Card> getCardsByUser(User user) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Card> cq = cb.createQuery(Card.class);
		Root<Card> root = cq.from(Card.class);
		cq.where(cb.equal(root.get("user"), user));
		List<Card> cards = session.createQuery(cq).list();
		session.close();
		return cards;
	}

	@Override
	public int addCard(Card card) throws DatabaseException {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.save(card);
		s.getTransaction().commit();
		s.close();
		if (card.getCardId() == 0) {
			throw new DatabaseException("Unable to insert card data.");
		}
		return card.getCardId();
	}

	@Override
	public int updateCard(Card card) throws DatabaseException {
		Session session = sessionFactory.openSession();
		String hql = "update card set fullName = :fullName, cardNum = :cardNum, expiration = :expiration" 
				+ "where cardId = :cardId";
		Transaction transaction = session.beginTransaction();
		int row = session.createQuery(hql)
				.setParameter("fullName", card.getFullName())
				.setParameter("cardNum", card.getCardNum())
				.setParameter("expiration", card.getExpiration())
				.setParameter("cardId", card.getCardId())
				.executeUpdate();
		transaction.commit();
		session.close();
		if (row == 0) {
			throw new DatabaseException("Unable to update card data.");
		}
		return row;
	}

	@Override
	public int deleteCardById(int cardId) throws DatabaseException {
		Session session = sessionFactory.openSession();
		String hql = "delete from card where cardId = :cardId";
		Transaction transaction = session.beginTransaction();
		int row = session.createQuery(hql)
				.setParameter("cardId", cardId)
		        .executeUpdate();
		transaction.commit();
		session.close();
		if (row == 0) {
			throw new DatabaseException("Unable to delete card data.");
		}
		return row;
	}
}
