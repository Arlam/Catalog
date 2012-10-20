package my.catalog.service;

import java.util.List;
import java.util.Map;

import my.catalog.dao.AbstractDAOFactory;
import my.catalog.entities.FilmEntity;
import my.catalog.entities.FolderEntity;
import my.catalog.entities.GenreEntity;
import my.catalog.entities.LanguageEntity;
import my.catalog.model.IAppModel;

public abstract class AbstractController {
	private IAppModel model = null;
	AbstractDAOFactory abstractDAOFactory = null;

	protected AbstractController(IAppModel model) {
		this.model = model;
		this.abstractDAOFactory = AbstractDAOFactory.getActiveDaoFactory();
	}

	protected AbstractController(IAppModel model,
			AbstractDAOFactory abstractDAOFactory) {
		this.model = model;
		this.abstractDAOFactory = abstractDAOFactory;
	}

	abstract public void call(Map<String, Object> params);

	protected IAppModel getModel() {
		return model;
	}

	protected void updateFilmsModel() {
		List<FilmEntity> films = abstractDAOFactory.getFilmDAO().getAllFilms();
		getModel().getFilmsModel().setData(films);
	}

	protected void updatePathsModel() {
		List<FolderEntity> folders = abstractDAOFactory.getFolderDAO()
				.getFolders();
		getModel().getFoldersModel().setData(folders);
	}

	protected void updateLanguageModel() {
		List<LanguageEntity> languages = abstractDAOFactory.getLanguageDAO()
				.getAllLanguages();
		getModel().getLanguagesModel().setData(languages);
	}

	protected void updateGanreModel() {
		List<GenreEntity> ganres = abstractDAOFactory.getGenreDAO()
				.getAllGanres();
		getModel().getGenreModel().setData(ganres);
	}

}
