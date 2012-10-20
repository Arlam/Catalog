package my.catalog.model;

import java.util.ArrayList;
import java.util.List;

import my.catalog.entities.FilmEntity;

public class FilmsModel implements IFilmsModel, IModelManagement {
	private List<FilmEntity> films = new ArrayList<FilmEntity>();

	@Override
	public List<FilmEntity> getFilms() {
		return films;
	}

	@Override
	public void setData(List<FilmEntity> films) {
		this.films = films;
	}

}
