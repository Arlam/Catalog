package my.catalog.service;

import my.catalog.comparators.IFilmsComparator;
import my.catalog.model.IFilmsModel;

public class FilmsSorter {

	public void sortByColumn(IFilmsModel model, IFilmsComparator comparator) {
		model.order(comparator);
	}
}
