package com.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.dto.CartItem;
import com.dto.User;
import com.exception.DatabaseException;

public class CartItemRepositoryImpl implements CartItemRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public CartItem getCartItemById(int cartItemId) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<CartItem> cq = cb.createQuery(CartItem.class);
		Root<CartItem> root = cq.from(CartItem.class);
		cq.where(cb.equal(root.get("cartItemId"), cartItemId));
		CartItem cartItem = session.createQuery(cq).uniqueResult();
		session.close();
		return cartItem;
	}

	@Override
	public List<CartItem> getCartItemByUser(User user) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<CartItem> cq = cb.createQuery(CartItem.class);
		Root<CartItem> root = cq.from(CartItem.class);
		cq.where(cb.equal(root.get("user"), user));
		List<CartItem> cartItems = session.createQuery(cq).list();
		session.close();
		return cartItems;
	}

	@Override
	public int addCartItem(CartItem cartItem) throws DatabaseException {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.save(cartItem);
		s.getTransaction().commit();
		s.close();
		if (cartItem.getCartItemId() == 0) {
			throw new DatabaseException("Unable to insert cart item data.");
		}
		return cartItem.getCartItemId();
	}

	@Override
	public int updateCartItem(CartItem cartItem) throws DatabaseException {
		Session session = sessionFactory.openSession();
		String hql = "update cartitem set number = :number where cartItemId = :cartItemId";
		Transaction transaction = session.beginTransaction();
		int row = session.createQuery(hql)
				.setParameter("number", cartItem.getAmount())
				.setParameter("cartItemId", cartItem.getCartItemId())
				.executeUpdate();
		transaction.commit();
		session.close();
		if (row == 0) {
			throw new DatabaseException("Unable to update cart item data.");
		}
		return row;
	}

	@Override
	public int deleteCartItem(int cartItemId) throws DatabaseException {
		Session session = sessionFactory.openSession();
		String hql = "delete from cartitem where cartItemId = :cartItemId";
		Transaction transaction = session.beginTransaction();
		int row = session.createQuery(hql)
				.setParameter("cartItemId", cartItemId)
		        .executeUpdate();
		transaction.commit();
		session.close();
		if (row == 0) {
			throw new DatabaseException("Unable to delete cart item data.");
		}
		return row;
	}

}
