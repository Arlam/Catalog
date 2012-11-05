package my.catalog.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import my.catalog.entities.FilmEntity;

public class FilmsModel implements IFilmsModel, IModelManagement {
	private List<FilmEntity> films = new ArrayList<FilmEntity>();

	@Override
	public List<FilmEntity> getFilms() {
		return films;
	}

	@Override
	public FilmEntity getFilm(int id) {
		return films.get(id);
	}

	@Override
	public void setData(List<FilmEntity> films) {
		this.films = films;
	}

	@Override
	public void order(Comparator<FilmEntity> comparator) {
		Collections.sort(films, comparator);

	}

	@Override
	public void addFilm(FilmEntity film) {
		films.add(film);

	}

	@Override
	public void update(FilmEntity film) {
		for (int i = 0; i < films.size(); i++) {
			if (films.get(i).getId() == film.getId()) {
				films.set(i, film);
			}
		}

	}

}
