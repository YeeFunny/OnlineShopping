package com.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Order;
import com.dto.User;
import com.exception.DatabaseException;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Order getOrderById(int orderId) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Order.class);
		cr.add(Restrictions.eq("order", orderId));
		Order order = (Order) cr.uniqueResult();
		session.close();
		return order;
	}

	@Override
	public List<Order> getOrdersByUser(User user) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Order.class);
		cr.add(Restrictions.eq("user", user));
		List<Order> orders = cr.list();
		session.close();
		return orders;
	}

	@Override
	public int addOrder(Order order) throws DatabaseException {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.save(order);
		s.getTransaction().commit();
		s.close();
		if (order.getOrderId() == 0) {
			throw new DatabaseException("Unable to insert order data.");
		}
		return order.getOrderId();
	}

	@Override
	public int updateOrder(Order order) throws DatabaseException {
		Session session = sessionFactory.openSession();
		String hql = "update order set fullName = :fullName, cardNum = :cardNum, expiration = :expiration" 
				+ "where cardId = :cardId";
		Transaction transaction = session.beginTransaction();
		int row = session.createQuery(hql)
//				.setParameter("fullName", card.getFullName())
//				.setParameter("cardNum", card.getCardNum())
//				.setParameter("expiration", card.getExpiration())
//				.setParameter("cardId", card.getCardId())
				.executeUpdate();
		transaction.commit();
		session.close();
		if (row == 0) {
			throw new DatabaseException("Unable to update card data.");
		}
		return row;
	}

}
