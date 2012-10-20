package my.catalog.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import my.catalog.dao.AbstractDAOFactory;
import my.catalog.dao.FilmDAO;
import my.catalog.dao.FolderDAO;
import my.catalog.dao.GenreDAO;
import my.catalog.dao.LanguageDAO;
import my.catalog.entities.FilmEntity;
import my.catalog.entities.FolderEntity;
import my.catalog.entities.GenreEntity;
import my.catalog.entities.LanguageEntity;
import my.catalog.model.AppModel;
import my.catalog.model.IAppModel;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class DataLoaderTests {
	private IAppModel model = new AppModel();

	@Before
	public void init() {
		List<FilmEntity> films = new ArrayList<FilmEntity>();
		films.add(new FilmEntity());
		films.add(new FilmEntity());
		FilmDAO filmDAO = EasyMock.createMock(FilmDAO.class);
		EasyMock.expect(filmDAO.getAllFilms()).andReturn(films);
		EasyMock.replay(filmDAO);

		List<GenreEntity> genres = new ArrayList<GenreEntity>();
		genres.add(new GenreEntity());
		genres.add(new GenreEntity());
		GenreDAO genreDAO = EasyMock.createMock(GenreDAO.class);
		EasyMock.expect(genreDAO.getAllGanres()).andReturn(genres);
		EasyMock.replay(genreDAO);

		List<FolderEntity> folders = new ArrayList<FolderEntity>();
		folders.add(new FolderEntity());
		folders.add(new FolderEntity());
		FolderDAO folderDAO = EasyMock.createMock(FolderDAO.class);
		EasyMock.expect(folderDAO.getFolders()).andReturn(folders);
		EasyMock.replay(folderDAO);

		List<LanguageEntity> languages = new ArrayList<LanguageEntity>();
		languages.add(new LanguageEntity());
		languages.add(new LanguageEntity());
		LanguageDAO languageDAO = EasyMock.createMock(LanguageDAO.class);
		EasyMock.expect(languageDAO.getAllLanguages()).andReturn(languages);
		EasyMock.replay(languageDAO);

		AbstractDAOFactory mockDAO = EasyMock
				.createMock(AbstractDAOFactory.class);
		EasyMock.expect(mockDAO.getFilmDAO()).andReturn(filmDAO);
		EasyMock.expect(mockDAO.getGenreDAO()).andReturn(genreDAO);
		EasyMock.expect(mockDAO.getFolderDAO()).andReturn(folderDAO);
		EasyMock.expect(mockDAO.getLanguageDAO()).andReturn(languageDAO);
		EasyMock.replay(mockDAO);
		DataLoader dataLoader = new DataLoader(model, mockDAO);
		dataLoader.updateAllModels();
	}

	@Test
	public void testLoadFilms() {
		assertEquals(2, model.getFilmsModel().getFilms().size());
	}

	@Test
	public void testLoadFolders() {
		assertEquals(2, model.getFoldersModel().getFolders().size());
	}

	@Test
	public void testLoadGenres() {
		assertEquals(2, model.getGenreModel().getGenres().size());
	}

	@Test
	public void testLoadLanguages() {
		assertEquals(2, model.getLanguagesModel().getLanguages().size());
	}
}
