package my.catalog.dao.impl;

import my.catalog.dao.IMovieDAO;
import my.catalog.entities.FilmEntity;

import org.springframework.stereotype.Repository;

@Repository
public class MovieDAO extends HibernateGenericDAO<FilmEntity> implements
		IMovieDAO {

	public MovieDAO() {
		super(FilmEntity.class);
	}

}
