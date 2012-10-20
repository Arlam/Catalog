package my.catalog.dao;

import java.util.List;

import my.catalog.entities.LanguageEntity;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LanguageDAOImpl implements LanguageDAO {
	private SessionFactory sessionFactory;

	public LanguageDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<LanguageEntity> getAllLanguages() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from LanguageEntity");
		@SuppressWarnings("unchecked")
		List<LanguageEntity> entities = query.list();
		session.getTransaction().commit();
		session.close();
		return entities;
	}
}
