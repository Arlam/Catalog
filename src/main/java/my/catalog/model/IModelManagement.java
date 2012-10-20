package my.catalog.model;

import java.util.List;

import my.catalog.entities.FilmEntity;

public interface IModelManagement {

	public void setData(List<FilmEntity> films);

}
