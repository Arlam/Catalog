package my.catalog.service;

import java.util.Map;

import my.catalog.dao.AbstractDAOFactory;
import my.catalog.dao.FilmDAO;
import my.catalog.entities.FilmEntity;
import my.catalog.model.IAppModel;

public class FilmController extends AbstractController {

	private static final Object FILM_VALUE = "Film";
	private FilmDAO filmDAO;

	public FilmController(IAppModel model) {
		super(model);
		filmDAO = AbstractDAOFactory.getActiveDaoFactory().getFilmDAO();
	}

	@Override
	public void call(Map<String, Object> params) {
		FilmEntity film = (FilmEntity) params.get(FILM_VALUE);
		if (film == null) {
			throw new IllegalArgumentException();
		}
		filmDAO.creatrFilm(film);
		updateFilmsModel();
	}

	public void updateFilm(FilmEntity film) {
		filmDAO.updateFilm(film);
		updateFilmsModel();
	}

}
