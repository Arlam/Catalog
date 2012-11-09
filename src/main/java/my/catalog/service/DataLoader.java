package my.catalog.service;

import java.util.List;
import java.util.Map;

import my.catalog.dao.AbstractDAOFactory;
import my.catalog.entities.FilmEntity;
import my.catalog.entities.FolderEntity;
import my.catalog.entities.GenreEntity;
import my.catalog.entities.LanguageEntity;
import my.catalog.model.IAppModel;

public class DataLoader {
	private IAppModel appModel;
	private AbstractDAOFactory abstractDAOFactory;

	public DataLoader(IAppModel model, AbstractDAOFactory abstractDAOFactory) {
		this.appModel = model;
		this.abstractDAOFactory = abstractDAOFactory;
	}

	public void call(Map<String, Object> params) {
		updateFilmsModel();
	}

	public void updateAllModels() {
		updateFoldersModel();
		updateLanguageModel();
		updateGanreModel();
		updateFilmsModel();
	}

	protected void updateFilmsModel() {
		List<FilmEntity> films = abstractDAOFactory.getFilmDAO().getAllFilms();
		appModel.getFilmsModel().add(films);
	}

	public void updateFoldersModel() {
		List<FolderEntity> folders = abstractDAOFactory.getFolderDAO()
				.getFolders();
		appModel.getFoldersModel().add(folders);
	}

	public void updateLanguageModel() {
		List<LanguageEntity> languages = abstractDAOFactory.getLanguageDAO()
				.getAllLanguages();
		appModel.getLanguagesModel().add(languages);
	}

	public void updateGanreModel() {
		List<GenreEntity> ganres = abstractDAOFactory.getGenreDAO()
				.getAllGanres();
		appModel.getGenreModel().add(ganres);
	}
}
