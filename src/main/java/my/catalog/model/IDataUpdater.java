package my.catalog.model;

import java.util.List;

public interface IDataUpdater<T> {
	void add(T entity);

	void add(List<T> entities);

	void update(T entity);

	void delete(T entity);
}
