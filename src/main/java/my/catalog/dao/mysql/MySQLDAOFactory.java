package my.catalog.dao.mysql;

import my.catalog.dao.AbstractDAOFactory;
import my.catalog.dao.GenericDAO;
import my.catalog.entities.FilmEntity;
import my.catalog.entities.FolderEntity;
import my.catalog.entities.GenreEntity;
import my.catalog.entities.LanguageEntity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MySQLDAOFactory extends AbstractDAOFactory {
	private GenericDAO<FilmEntity> filmDAO;
	private GenericDAO<FolderEntity> pathDAO;
	private GenericDAO<LanguageEntity> languageDAO;
	private GenericDAO<GenreEntity> genreDAO;

	public MySQLDAOFactory() {
		Configuration cfg = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory(serviceRegistry);

		filmDAO = new GenericDAOImpl<FilmEntity>(sessionFactory,
				FilmEntity.class);
		pathDAO = new GenericDAOImpl<FolderEntity>(sessionFactory,
				FolderEntity.class);
		languageDAO = new GenericDAOImpl<LanguageEntity>(sessionFactory,
				LanguageEntity.class);
		genreDAO = new GenericDAOImpl<GenreEntity>(sessionFactory,
				GenreEntity.class);

	}

	@Override
	public GenericDAO<FilmEntity> getFilmDAO() {
		return filmDAO;
	}

	@Override
	public GenericDAO<FolderEntity> getFolderDAO() {
		return pathDAO;
	}

	@Override
	public GenericDAO<LanguageEntity> getLanguageDAO() {
		return languageDAO;
	}

	@Override
	public GenericDAO<GenreEntity> getGenreDAO() {
		return genreDAO;
	}

}
