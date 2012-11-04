package my.catalog.comparators;

import my.catalog.entities.FilmEntity;

public class NameComparator implements IFilmsComparator {
	private final FieldComparator<String> comparator;

	public NameComparator(boolean isForwardOrder) {
		comparator = new FieldComparator<String>(isForwardOrder);
	}

	@Override
	public int compare(FilmEntity film1, FilmEntity film2) {
		return comparator.compare(film1.getName(), film2.getName());

	}

}
