package my.catalog.model;

import java.util.ArrayList;
import java.util.List;

import my.catalog.entities.GenreEntity;

public class GenresModel implements IGenresModel {
	List<GenreEntity> genres = new ArrayList<GenreEntity>();

	@Override
	public void setData(List<GenreEntity> genres) {
		this.genres = genres;

	}

	@Override
	public List<GenreEntity> getGenres() {
		return genres;
	}

}
