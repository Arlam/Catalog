package my.catalog.comparators;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import my.catalog.entities.FilmEntity;

import org.junit.Before;
import org.junit.Test;

public class NameComparatorTests {
	private List<FilmEntity> films = new ArrayList<FilmEntity>();
	private FilmEntity film0 = new FilmEntity();
	private FilmEntity film1 = new FilmEntity();
	private FilmEntity film2 = new FilmEntity();
	private FilmEntity film3 = new FilmEntity();
	private FilmEntity film4 = new FilmEntity();

	@Before
	public void init() {
		film0.setName("NS");
		film1.setName("C");
		film2.setName(null);
		film3.setName("D");
		film4.setName("Z");
		films.add(film0);
		films.add(film1);
		films.add(film2);
		films.add(film3);
		films.add(film4);
	}

	@Test
	public void testSortingByName() {
		IFilmsComparator nameComparator = new NameComparator(true);
		Collections.sort(films, nameComparator);
		assertEquals(film1.getName(), films.get(0).getName());
		assertEquals(film3.getName(), films.get(1).getName());
		assertEquals(film0.getName(), films.get(2).getName());
		assertEquals(film4.getName(), films.get(3).getName());
		assertEquals(film2.getName(), films.get(4).getName());
	}

	@Test
	public void testSortingInReverseByName() {
		IFilmsComparator nameComparator = new NameComparator(false);
		Collections.sort(films, nameComparator);
		assertEquals(film4.getName(), films.get(0).getName());
		assertEquals(film0.getName(), films.get(1).getName());
		assertEquals(film3.getName(), films.get(2).getName());
		assertEquals(film1.getName(), films.get(3).getName());
		assertEquals(film2.getName(), films.get(4).getName());
	}
}
