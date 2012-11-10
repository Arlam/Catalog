package my.catalog.service;

import java.util.List;

import my.catalog.dao.AbstractDAOFactory;
import my.catalog.entities.FilmEntity;
import my.catalog.entities.FolderEntity;
import my.catalog.entities.GenreEntity;
import my.catalog.entities.LanguageEntity;
import my.catalog.model.IAppModelFactory;

public class DataLoader {
	private IAppModelFactory appModel;
	private AbstractDAOFactory abstractDAOFactory;

	public DataLoader(IAppModelFactory model, AbstractDAOFactory abstractDAOFactory) {
		this.appModel = model;
		this.abstractDAOFactory = abstractDAOFactory;
	}

	public void updateAllModels() {
		updateFoldersModel();
		updateLanguageModel();
		updateGanreModel();
		updateFilmsModel();
	}

	protected void updateFilmsModel() {
		List<FilmEntity> films = abstractDAOFactory.getFilmDAO().getAll();
		appModel.getFilmsModel().add(films);
	}

	public void updateFoldersModel() {
		List<FolderEntity> folders = abstractDAOFactory.getFolderDAO().getAll();
		appModel.getFoldersModel().add(folders);
	}

	public void updateLanguageModel() {
		List<LanguageEntity> languages = abstractDAOFactory.getLanguageDAO()
				.getAll();
		appModel.getLanguagesModel().add(languages);
	}

	public void updateGanreModel() {
		List<GenreEntity> ganres = abstractDAOFactory.getGenreDAO().getAll();
		appModel.getGenreModel().add(ganres);
	}
}
