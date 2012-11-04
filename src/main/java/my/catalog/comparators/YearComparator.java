package my.catalog.comparators;

import my.catalog.entities.FilmEntity;

public class YearComparator implements IFilmsComparator {
	private FieldComparator<Integer> comparator;

	public YearComparator(boolean isForwardOrder) {
		comparator = new FieldComparator<Integer>(isForwardOrder);
	}

	@Override
	public int compare(FilmEntity o1, FilmEntity o2) {
		return comparator.compare(o1.getYear(), o2.getYear());
	}
}
