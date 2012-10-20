package my.catalog.dao;

import java.util.List;

import my.catalog.entities.FilmEntity;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FilmDAOImpl implements FilmDAO {
	private static final Logger LOG = Logger.getLogger(FilmDAOImpl.class);
	private SessionFactory sessionFactory;

	public FilmDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Integer creatrFilm(FilmEntity film) {
		Session session = sessionFactory.openSession();
		Integer id = null;
		try {
			session.beginTransaction();
			id = (Integer) session.save(film);
			session.getTransaction().commit();
			LOG.info(film.getName() + " added");
		} catch (HibernateException e) {
			LOG.warn(e.getMessage());
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return id;
	}

	@Override
	public FilmEntity getFilmById(int id) {
		Session session = sessionFactory.openSession();
		FilmEntity entity = (FilmEntity) session.get(FilmEntity.class, id);
		session.close();
		return entity;
	}

	@Override
	public List<FilmEntity> getAllFilms() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from FilmEntity");
		@SuppressWarnings("unchecked")
		List<FilmEntity> entities = query.list();
		session.getTransaction().commit();
		session.close();
		return entities;
	}

	@Override
	public void delete(FilmEntity film) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(film);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateFilm(FilmEntity film) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(film);
		session.getTransaction().commit();
	}

}
