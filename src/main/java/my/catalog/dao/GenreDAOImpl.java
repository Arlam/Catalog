package my.catalog.dao;

import java.util.List;

import my.catalog.entities.GenreEntity;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GenreDAOImpl implements GenreDAO {

	private SessionFactory sessionFactory;

	public GenreDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<GenreEntity> getAllGanres() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from GenreEntity");
		@SuppressWarnings("unchecked")
		List<GenreEntity> entities = query.list();
		session.getTransaction().commit();
		session.close();
		return entities;
	}
}
