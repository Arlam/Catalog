package my.catalog.dao.impl;

import my.catalog.dao.ILanguageDAO;
import my.catalog.entities.LanguageEntity;

import org.springframework.stereotype.Repository;

@Repository
public class LanguageDAO extends HibernateGenericDAO<LanguageEntity> implements
		ILanguageDAO {

	public LanguageDAO() {
		super(LanguageEntity.class);
	}

}
