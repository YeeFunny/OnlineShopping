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

import com.dto.Address;
import com.dto.User;
import com.exception.DatabaseException;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Address getAddressById(int addressId) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Address> cq = cb.createQuery(Address.class);
		Root<Address> root = cq.from(Address.class);
		cq.where(cb.equal(root.get("addressId"), addressId));
		Address address = session.createQuery(cq).uniqueResult();
		session.close();
		return address;
	}

	@Override
	public List<Address> getAddressByUser(User user) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Address> cq = cb.createQuery(Address.class);
		Root<Address> root = cq.from(Address.class);
		cq.where(cb.equal(root.get("user"), user));
		List<Address> addresses = session.createQuery(cq).list();
		session.close();
		return addresses;
	}

	@Override
	public int addAddress(Address address) throws DatabaseException {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.save(address);
		s.getTransaction().commit();
		s.close();
		if (address.getAddressId() == 0) {
			throw new DatabaseException("Unable to insert address data.");
		}
		return address.getAddressId();
	}

	@Override
	public int updateAddress(Address address) throws DatabaseException {
		Session session = sessionFactory.openSession();
		String hql = "update address set fullName = :fullName, street = :street, streetTwo = :streetTwo" 
				+ "city = :city, state = :state, zip = :zip, country = :country where addressId = :addressId";
		Transaction transaction = session.beginTransaction();
		int row = session.createQuery(hql)
				.setParameter("fullName", address.getFullName())
				.setParameter("street", address.getStreet())
				.setParameter("streetTwo", address.getStreetTwo())
				.setParameter("city", address.getCity())
				.setParameter("state", address.getState())
				.setParameter("zip", address.getZip())
				.setParameter("country", address.getCountry())
				.setParameter("addressId", address.getAddressId())
				.executeUpdate();
		transaction.commit();
		session.close();
		if (row == 0) {
			throw new DatabaseException("Unable to update address data.");
		}
		return row;
	}

	@Override
	public int deleteAddressById(int addressId) throws DatabaseException {
		Session session = sessionFactory.openSession();
		String hql = "delete from address where addressId = :addressId";
		Transaction transaction = session.beginTransaction();
		int row = session.createQuery(hql)
				.setParameter("addressId", addressId)
		        .executeUpdate();
		transaction.commit();
		session.close();
		if (row == 0) {
			throw new DatabaseException("Unable to delete address data.");
		}
		return row;
	}

}
