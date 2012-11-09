package my.catalog.service;

import my.catalog.dao.AbstractDAOFactory;
import my.catalog.dao.FilmDAO;
import my.catalog.entities.FilmEntity;
import my.catalog.model.IDataUpdater;

public class FilmController {

	private final FilmDAO filmDAO;
	private final IDataUpdater<FilmEntity> model;

	public FilmController(IDataUpdater<FilmEntity> model) {
		this.model = model;
		filmDAO = AbstractDAOFactory.getActiveDaoFactory().getFilmDAO();
	}

	public void updateFilm(FilmEntity film) {
		filmDAO.updateFilm(film);
		model.update(film);
	}

}
