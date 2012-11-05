package my.catalog.service;

import my.catalog.dao.AbstractDAOFactory;
import my.catalog.dao.FilmDAO;
import my.catalog.entities.FilmEntity;
import my.catalog.model.IAppModel;

public class FilmController {

	private IAppModel appModel;
	private FilmDAO filmDAO;

	public FilmController(IAppModel model) {
		this.appModel = model;
		filmDAO = AbstractDAOFactory.getActiveDaoFactory().getFilmDAO();
	}

	public void updateFilm(FilmEntity film) {
		filmDAO.updateFilm(film);
		appModel.getFilmsModel().update(film);
	}

}
