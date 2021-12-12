package com.xworkz.mobile.dao;

import java.util.List;
import java.util.Objects;

import org.hibernate.query.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.sunita.util.SFUtil;

public class MobileDAOImpl implements MobileDAO {
	private SessionFactory factory = SFUtil.getFactory();
	Transaction trans = null;

	@Override
	public int save(MobileEntity entity) {
		int key = 0;
		try (Session session = factory.openSession()) {
			trans = session.beginTransaction();
			key = (int) session.save(entity);
			session.flush();
			session.clear();

			trans.commit();
			return key;
		}
	}

	@Override
	public void readAll(int id) {
		Session session = null;
		try {
			session = factory.openSession();
			Query query = session.getNamedQuery("readAll");
			List<MobileEntity> list = query.list();
			System.out.println(list);

		} catch (HibernateException e) {

		} finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not  closed");
			}
		}
	}

	@Override
	public double readPriceByName(String name) {
		System.out.println("invoked readPriceByName()");
		Session session = null;
		try {
			session = factory.openSession();
			Query query = session.getNamedQuery("readPriceByName");
			query.setParameter("Name", name);
			Object obj = query.uniqueResult();
			if (obj != null) {
				Double price = (Double) obj;
				return price;

			}

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session closed");

			} else {
				System.out.println("session not closed");
			}
		}
		return 0;
	}

	@Override
	public double readTotalPrice() {
		System.out.println("invoked readTotalPrice()");
		Session session = null;
		try {
			session = factory.openSession();
			Query query = session.getNamedQuery("readTotalPrice");
			Object obj = query.uniqueResult();
			if (obj != null) {
				Double totalprice = (Double) obj;
				return totalprice;

			}

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session closed");

			} else {
				System.out.println("session not closed");
			}
		}

		return 0;
	}

	@Override
	public double readMaxPrice() {
		System.out.println("invoked readMaxPrice()");
		Session session = null;
		try {
			session = factory.openSession();
			Query query = session.getNamedQuery("readMaxPrice");
			Object obj = query.uniqueResult();
			if (obj != null) {
				Double maxprice = (Double) obj;
				return maxprice;

			}

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session closed");

			} else {
				System.out.println("session not closed");
			}
		}

		return 0;
	}

	@Override
	public double readMinPrice() {
		System.out.println("invoked readMinPrice()");
		Session session = null;
		try {
			session = factory.openSession();
			Query query = session.getNamedQuery("readMinPrice");
			Object obj = query.uniqueResult();
			if (obj != null) {
				Double minprice = (Double) obj;
				return minprice;

			}

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session closed");

			} else {
				System.out.println("session not closed");
			}
		}
		return 0;
	}

	public void updatePriceByName(double price, String name) {
		try (Session session = factory.openSession()) {
			Query query = session.getNamedQuery("updatePriceByName");
			query.setParameter("Price", price);
			query.setParameter("Name", name);
			session.beginTransaction();
			query.executeUpdate();
			session.getTransaction().commit();

		}
	}

}
