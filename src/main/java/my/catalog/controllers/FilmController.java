package my.catalog.controllers;

import my.catalog.dao.IMovieDAO;
import my.catalog.entities.FilmEntity;
import my.catalog.model.IDataUpdater;

import org.springframework.beans.factory.annotation.Autowired;

public class FilmController {
	@Autowired
	private IMovieDAO movieDAO;
	private final IDataUpdater<FilmEntity> model;

	public FilmController(IDataUpdater<FilmEntity> model) {
		this.model = model;
	}

	public void updateFilm(FilmEntity film) {
		movieDAO.update(film);
		model.update(film);
	}

}
