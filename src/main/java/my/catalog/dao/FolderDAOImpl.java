package my.catalog.dao;

import java.util.List;

import my.catalog.entities.FolderEntity;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FolderDAOImpl implements FolderDAO {
	private static final Logger LOG = Logger.getLogger(FolderDAOImpl.class);
	private SessionFactory sessionFactory;

	public FolderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Integer createFolder(FolderEntity path) {
		Integer id = null;
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			id = (Integer) session.save(path);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			LOG.warn(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return id;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FolderEntity> getFolders() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from FolderEntity");
		List<FolderEntity> entities = query.list();
		session.getTransaction().commit();
		session.close();
		return entities;
	}

	@Override
	public FolderEntity getFolder(Integer id) {
		Session session = sessionFactory.openSession();
		FolderEntity entity = (FolderEntity) session
				.get(FolderEntity.class, id);
		session.close();
		return entity;
	}

}
