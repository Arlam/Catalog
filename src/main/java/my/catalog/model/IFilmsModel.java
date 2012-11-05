package my.catalog.model;

import java.util.List;

import my.catalog.entities.FilmEntity;

public interface IFilmsModel extends IModelManagement {
	public List<FilmEntity> getFilms();

	public FilmEntity getFilm(int id);

}
