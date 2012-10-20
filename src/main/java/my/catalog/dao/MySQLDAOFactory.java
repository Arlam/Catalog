package my.catalog.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MySQLDAOFactory extends AbstractDAOFactory {
	private FilmDAO filmDAO;
	private FolderDAO pathDAO;
	private LanguageDAO languageDAO;
	private GenreDAO genreDAO;

	public MySQLDAOFactory() {
		Configuration cfg = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory(serviceRegistry);

		filmDAO = new FilmDAOImpl(sessionFactory);
		pathDAO = new FolderDAOImpl(sessionFactory);
		languageDAO = new LanguageDAOImpl(sessionFactory);
		genreDAO = new GenreDAOImpl(sessionFactory);

	}

	@Override
	public FilmDAO getFilmDAO() {
		return filmDAO;
	}

	@Override
	public FolderDAO getFolderDAO() {
		return pathDAO;
	}

	@Override
	public LanguageDAO getLanguageDAO() {
		return languageDAO;
	}

	@Override
	public GenreDAO getGenreDAO() {
		return genreDAO;
	}

}
