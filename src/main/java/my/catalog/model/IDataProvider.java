package my.catalog.model;

import java.util.List;

public interface IDataProvider<T> {
	public List<T> getAll();

	public T get(Integer id);
}
