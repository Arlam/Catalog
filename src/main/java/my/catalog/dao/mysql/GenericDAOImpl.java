package my.catalog.dao.mysql;

import java.io.Serializable;
import java.util.List;

import my.catalog.dao.GenericDAO;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GenericDAOImpl<T extends Serializable> implements GenericDAO<T> {
	private static final Logger LOG = Logger.getLogger(GenericDAOImpl.class);
	private SessionFactory sessionFactory;
	private Class<T> type;

	public GenericDAOImpl(SessionFactory sessionFactory, Class<T> type) {
		this.sessionFactory = sessionFactory;
		this.type = type;
	}

	@Override
	public Integer add(T entity) {
		Integer id = null;
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			id = (Integer) session.save(entity);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return id;
	}

	@Override
	public T get(Integer id) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		T entity = (T) session.get(type, id);
		return entity;
	}

	@Override
	public List<T> getAll() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from " + type.getName()); //$NON-NLS-1$
		@SuppressWarnings("unchecked")
		List<T> entities = query.list();
		session.getTransaction().commit();
		session.close();
		return entities;
	}

	@Override
	public void delete(T entity) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			LOG.error(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void update(T entity) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			LOG.error(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

}
