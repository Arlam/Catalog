package my.catalog.controllers;

import my.catalog.dao.IMovieDAO;
import my.catalog.entities.FilmEntity;
import my.catalog.model.IDataUpdater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FilmController {
	@Autowired
	private IMovieDAO movieDAO;
	private IDataUpdater<FilmEntity> model;

	public FilmController() {

	}

	public void setModel(IDataUpdater<FilmEntity> model) {
		this.model = model;
	}

	public void updateFilm(FilmEntity film) {
		movieDAO.update(film);
		model.update(film);
	}

}
