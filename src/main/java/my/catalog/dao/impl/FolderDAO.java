package my.catalog.dao.impl;

import my.catalog.dao.IFolderDAO;
import my.catalog.entities.FolderEntity;

import org.springframework.stereotype.Repository;

@Repository
public class FolderDAO extends HibernateGenericDAO<FolderEntity> implements
		IFolderDAO {

	public FolderDAO() {
		super(FolderEntity.class);
	}

}
