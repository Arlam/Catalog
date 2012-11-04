package my.catalog.comparators;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import my.catalog.entities.FilmEntity;

import org.junit.Before;
import org.junit.Test;

public class YearComparatorTests {
	private List<FilmEntity> films = new ArrayList<FilmEntity>();
	private FilmEntity film0 = new FilmEntity();
	private FilmEntity film1 = new FilmEntity();
	private FilmEntity film2 = new FilmEntity();
	private FilmEntity film3 = new FilmEntity();
	private FilmEntity film4 = new FilmEntity();

	@Before
	public void init() {
		film0.setName("NS");
		film0.setYear(2010);

		film1.setName("C");
		film1.setYear(2005);

		film2.setName(null);
		film2.setYear(null);

		film3.setName("D");
		film3.setYear(2015);

		film4.setYear(2011);
		film4.setName("Z");

		films.add(film0);
		films.add(film1);
		films.add(film2);
		films.add(film3);
		films.add(film4);
	}

	@Test
	public void testSortingByYear() {
		IFilmsComparator nameComparator = new YearComparator(true);
		Collections.sort(films, nameComparator);
		assertEquals(film1.getYear(), films.get(0).getYear());
		assertEquals(film0.getYear(), films.get(1).getYear());
		assertEquals(film4.getYear(), films.get(2).getYear());
		assertEquals(film3.getYear(), films.get(3).getYear());
		assertEquals(film2.getYear(), films.get(4).getYear());
	}

	@Test
	public void testSortingInReverseByYear() {
		IFilmsComparator nameComparator = new YearComparator(false);
		Collections.sort(films, nameComparator);
		assertEquals(film3.getYear(), films.get(0).getYear());
		assertEquals(film4.getYear(), films.get(1).getYear());
		assertEquals(film0.getYear(), films.get(2).getYear());
		assertEquals(film1.getYear(), films.get(3).getYear());
		assertEquals(film2.getYear(), films.get(4).getYear());
	}
}
