package my.catalog.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import my.catalog.model.IDataProvider;
import my.catalog.model.SortableModel;

public class CurrentSessionDataModel<T> implements Observer, IDataProvider<T>,
		SortableModel<T> {
	private final List<T> list = new ArrayList<T>();

	public CurrentSessionDataModel() {

	}

	@Override
	public List<T> getAll() {
		return new ArrayList<T>(list);
	}

	@Override
	public T get(Integer id) {
		return list.get(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object updatedList) {
		list.clear();
		list.addAll((List<T>) updatedList);
	}

	@Override
	public void sort(Comparator<T> comparator) {
		Collections.sort(list, comparator);
	}
}
