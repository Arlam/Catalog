package my.catalog.model;

import java.util.Comparator;
import java.util.List;

import my.catalog.entities.FilmEntity;

public interface IModelManagement {
	public void order(Comparator<FilmEntity> comparator);

	public void setData(List<FilmEntity> films);

}
