package my.catalog.dao;

import my.catalog.dao.mysql.MySQLDAOFactory;
import my.catalog.entities.FilmEntity;
import my.catalog.entities.FolderEntity;
import my.catalog.entities.GenreEntity;
import my.catalog.entities.LanguageEntity;

public abstract class AbstractDAOFactory {
	private static AbstractDAOFactory daoFactory;

	public abstract GenericDAO<FilmEntity> getFilmDAO();

	public abstract GenericDAO<FolderEntity> getFolderDAO();

	public abstract GenericDAO<LanguageEntity> getLanguageDAO();

	public abstract GenericDAO<GenreEntity> getGenreDAO();

	public static AbstractDAOFactory initFactory(FactoryType type) {
		switch (type) {
		case MY_SQL_FACTORY:
			daoFactory = new MySQLDAOFactory();
			break;
		}
		return getActiveDaoFactory();
	}

	/**
	 * Need run initFactory before use this method or you get null
	 * 
	 * @return returns static factory
	 */
	public static AbstractDAOFactory getActiveDaoFactory() {
		return daoFactory;
	}
}
