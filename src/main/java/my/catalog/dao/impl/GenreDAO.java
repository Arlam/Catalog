package my.catalog.dao.impl;

import my.catalog.dao.IGenreDAO;
import my.catalog.entities.GenreEntity;

import org.springframework.stereotype.Repository;

@Repository
public class GenreDAO extends HibernateGenericDAO<GenreEntity> implements
		IGenreDAO {

	public GenreDAO() {
		super(GenreEntity.class);
	}

}
