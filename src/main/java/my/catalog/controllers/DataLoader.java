package my.catalog.controllers;

import java.util.List;

import my.catalog.dao.IFolderDAO;
import my.catalog.dao.IGenreDAO;
import my.catalog.dao.ILanguageDAO;
import my.catalog.dao.IMovieDAO;
import my.catalog.entities.FilmEntity;
import my.catalog.entities.FolderEntity;
import my.catalog.entities.GenreEntity;
import my.catalog.entities.LanguageEntity;
import my.catalog.model.IAppModelFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DataLoader {
	private IAppModelFactory appModel;

	@Autowired
	private IMovieDAO movieDAO;
	@Autowired
	private IFolderDAO folderDAO;
	@Autowired
	private ILanguageDAO languageDAO;
	@Autowired
	private IGenreDAO genreDAO;

	public DataLoader() {
		//
	}

	public void setAppModel(IAppModelFactory appModel) {
		this.appModel = appModel;
	}

	public void updateAllModels() {
		updateFoldersModel();
		updateLanguageModel();
		updateGanreModel();
		updateFilmsModel();
	}

	protected void updateFilmsModel() {
		List<FilmEntity> films = movieDAO.getAll();
		appModel.getFilmsModel().add(films);
	}

	public void updateFoldersModel() {
		List<FolderEntity> folders = folderDAO.getAll();
		appModel.getFoldersModel().add(folders);
	}

	public void updateLanguageModel() {
		List<LanguageEntity> languages = languageDAO.getAll();
		appModel.getLanguagesModel().add(languages);
	}

	public void updateGanreModel() {
		List<GenreEntity> ganres = genreDAO.getAll();
		appModel.getGenreModel().add(ganres);
	}

	public IMovieDAO getMovieDAO() {
		return movieDAO;
	}

	public void setMovieDAO(IMovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}
}
