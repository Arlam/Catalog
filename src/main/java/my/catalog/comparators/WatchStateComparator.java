package my.catalog.comparators;

import my.catalog.entities.FilmEntity;

public class WatchStateComparator implements IFilmsComparator {
	private FieldComparator<Boolean> comparator;

	public WatchStateComparator(boolean isForwardOrder) {
		comparator = new FieldComparator<Boolean>(isForwardOrder);
	}

	@Override
	public int compare(FilmEntity o1, FilmEntity o2) {
		return comparator.compare(o2.getWatched(), o1.getWatched());
	}

}
