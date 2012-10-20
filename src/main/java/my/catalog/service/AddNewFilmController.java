package my.catalog.service;

import java.util.Map;

import my.catalog.dao.AbstractDAOFactory;
import my.catalog.entities.FilmEntity;
import my.catalog.model.IAppModel;

public class AddNewFilmController extends AbstractController {

	private static final Object FILM_VALUE = "Film";

	protected AddNewFilmController(IAppModel model) {
		super(model);
	}

	@Override
	public void call(Map<String, Object> params) {
		FilmEntity film = (FilmEntity) params.get(FILM_VALUE);
		if (film == null) {
			throw new IllegalArgumentException();
		}
		AbstractDAOFactory.getActiveDaoFactory().getFilmDAO().creatrFilm(film);
		updateFilmsModel();
	}

}
