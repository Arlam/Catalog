package my.catalog.model;

public class AppModel implements IAppModel {
	private IFilmsModel filmsModel;
	private IFoldersModel pathsModel;
	private ILanguagesModel languagesModel;
	private IGenresModel genresModel;

	public AppModel() {
		filmsModel = new FilmsModel();
		pathsModel = new FoldersModel();
		languagesModel = new LanguagesModel();
		genresModel = new GenresModel();
	}

	@Override
	public IFilmsModel getFilmsModel() {
		return filmsModel;
	}

	@Override
	public IFoldersModel getFoldersModel() {
		return pathsModel;
	}

	@Override
	public ILanguagesModel getLanguagesModel() {
		return languagesModel;
	}

	@Override
	public IGenresModel getGenreModel() {
		return genresModel;
	}

}
