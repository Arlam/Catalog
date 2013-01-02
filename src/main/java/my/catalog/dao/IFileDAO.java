package my.catalog.dao;

import my.catalog.entities.FileEntity;

public interface IFileDAO extends GenericDAO<FileEntity> {

	public FileEntity findByPath(String absolutePath);
}
