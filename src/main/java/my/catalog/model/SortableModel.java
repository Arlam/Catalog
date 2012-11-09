package my.catalog.model;

import java.util.Comparator;

public interface SortableModel<T> {
	void sort(Comparator<T> comparator);
}
