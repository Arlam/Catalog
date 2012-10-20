package my.catalog.dao;


public abstract class AbstractDAOFactory {
	private static AbstractDAOFactory daoFactory;

	public abstract FilmDAO getFilmDAO();

	public abstract FolderDAO getFolderDAO();

	public abstract LanguageDAO getLanguageDAO();

	public abstract GenreDAO getGenreDAO();

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
