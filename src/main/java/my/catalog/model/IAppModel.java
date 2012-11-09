package my.catalog.model;

import my.catalog.entities.FilmEntity;
import my.catalog.entities.FolderEntity;
import my.catalog.entities.GenreEntity;
import my.catalog.entities.LanguageEntity;
import my.catalog.model.impl.ServerSideDataModel;

public interface IAppModel {

	public ServerSideDataModel<FilmEntity> getFilmsModel();

	public ServerSideDataModel<FolderEntity> getFoldersModel();

	public ServerSideDataModel<LanguageEntity> getLanguagesModel();

	public ServerSideDataModel<GenreEntity> getGenreModel();

}
