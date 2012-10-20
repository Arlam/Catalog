package my.catalog.swing.adapter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import my.catalog.entities.FilmEntity;
import my.catalog.model.IFilmsModel;
import my.catalog.swing.adapters.FilmsTableModel;

import org.junit.Before;
import org.junit.Test;

public class FilmsTableModelTests {

	private FilmsTableModel tableModel;

	private final static String FILM_NAME = "Name";
	private final static int FILM_YEAR = 2012;
	private static final Integer FILM_RATE = 10;
	private static final Boolean FILM_IS_WATCHED = true;
	private static final String FILM_PATH = "d:/temp/test.avi";

	@Before
	public void testModel() {
		IFilmsModel model = new IFilmsModel() {
			@Override
			public ArrayList<FilmEntity> getFilms() {
				ArrayList<FilmEntity> films = new ArrayList<FilmEntity>();

				FilmEntity film = new FilmEntity();
				film.setName(FILM_NAME);
				film.setYear(FILM_YEAR);
				film.setRate(FILM_RATE);
				film.setWatched(FILM_IS_WATCHED);
				// film.setLanguages(languages);
				film.setPath(FILM_PATH);

				films.add(film);
				return films;
			}

			@Override
			public void setData(List<FilmEntity> films) {
				// TODO Auto-generated method stub
				
			}
		};

		tableModel = new FilmsTableModel(model);

	}

	@Test
	public void testFieldName() {
		assertEquals(FILM_NAME, tableModel.getValueAt(0, 0));
	}

	@Test
	public void testFieldYear() {
		assertEquals(FILM_YEAR, tableModel.getValueAt(0, 1));
	}

	@Test
	public void testFieldRate() {
		assertEquals(FILM_RATE, tableModel.getValueAt(0, 3));
	}

	@Test
	public void testFieldWatched() {
		assertEquals(FILM_IS_WATCHED, tableModel.getValueAt(0, 4));
	}

	@Test
	public void testFieldPath() {
		assertEquals(FILM_PATH, tableModel.getValueAt(0, 5));
	}
}
