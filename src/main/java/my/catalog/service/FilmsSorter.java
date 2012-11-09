package my.catalog.service;

import my.catalog.comparators.IFilmsComparator;
import my.catalog.entities.FilmEntity;
import my.catalog.model.SortableModel;

public class FilmsSorter {

	public void sortByColumn(SortableModel<FilmEntity> model,
			IFilmsComparator comparator) {
		model.sort(comparator);
	}
}
