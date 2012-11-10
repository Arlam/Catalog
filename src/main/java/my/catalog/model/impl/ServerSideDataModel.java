package my.catalog.model.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import my.catalog.entities.IEntity;
import my.catalog.model.IDataProvider;
import my.catalog.model.IDataUpdater;

public class ServerSideDataModel<T extends IEntity> extends Observable
		implements IDataUpdater<T>, IDataProvider<T> {

	private final List<T> list = new ArrayList<T>();

	@Override
	public void add(T entity) {
		list.add(entity);
		notifyObservers(list);
	}

	@Override
	public void add(List<T> entities) {
		list.addAll(entities);
		notifyObservers(list);
	}

	@Override
	public void update(T entity) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == entity.getId()) {
				list.set(i, entity);
				break;
			}

		}
		// notifyObservers(list);
	}

	@Override
	public void delete(T entity) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == entity.getId()) {
				list.remove(i);
				break;
			}
		}
		notifyObservers(list);
	}

	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
		o.update(this, list);
	}

	@Override
	public List<T> getAll() {
		return list;
	}

	@Override
	public T get(Integer id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return list.get(i);
			}
		}
		return null;
	}
}
