package my.catalog.model.impl;

import my.catalog.entities.FilmEntity;
import my.catalog.entities.FolderEntity;
import my.catalog.entities.GenreEntity;
import my.catalog.entities.LanguageEntity;
import my.catalog.model.IAppModel;

public class AppModel implements IAppModel {
	private ServerSideDataModel<FilmEntity> filmsModel;
	private ServerSideDataModel<FolderEntity> pathsModel;
	private ServerSideDataModel<LanguageEntity> languagesModel;
	private ServerSideDataModel<GenreEntity> genresModel;

	public AppModel() {
		filmsModel = new ServerSideDataModel<FilmEntity>();
		pathsModel = new ServerSideDataModel<FolderEntity>();
		languagesModel = new ServerSideDataModel<LanguageEntity>();
		genresModel = new ServerSideDataModel<GenreEntity>();
	}

	@Override
	public ServerSideDataModel<FilmEntity> getFilmsModel() {
		return filmsModel;
	}

	@Override
	public ServerSideDataModel<FolderEntity> getFoldersModel() {
		return pathsModel;
	}

	@Override
	public ServerSideDataModel<LanguageEntity> getLanguagesModel() {
		return languagesModel;
	}

	@Override
	public ServerSideDataModel<GenreEntity> getGenreModel() {
		return genresModel;
	}

}
