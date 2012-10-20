package my.catalog.model;

import java.util.List;

import my.catalog.entities.GenreEntity;

public interface IGenresModel extends IGenresManager {

	public List<GenreEntity> getGenres();

}
