package my.catalog.comparators;

import my.catalog.entities.FilmEntity;

public class RateComparator implements IFilmsComparator {
	private FieldComparator<Integer> comparator;

	public RateComparator(boolean isForwardOrder) {
		comparator = new FieldComparator<Integer>(isForwardOrder);
	}

	@Override
	public int compare(FilmEntity o1, FilmEntity o2) {
		return comparator.compare(o1.getRate(), o2.getRate());
	}

}
