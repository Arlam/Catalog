package my.catalog.service;

import my.catalog.dao.AbstractDAOFactory;
import my.catalog.dao.GenericDAO;
import my.catalog.entities.FilmEntity;
import my.catalog.model.IDataUpdater;

public class FilmController {

	private final GenericDAO<FilmEntity> filmDAO;
	private final IDataUpdater<FilmEntity> model;

	public FilmController(IDataUpdater<FilmEntity> model) {
		this.model = model;
		filmDAO = AbstractDAOFactory.getActiveDaoFactory().getFilmDAO();
	}

	public void updateFilm(FilmEntity film) {
		filmDAO.update(film);
		model.update(film);
	}

}
