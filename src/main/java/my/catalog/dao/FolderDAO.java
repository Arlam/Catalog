package my.catalog.dao;

import java.util.List;

import my.catalog.entities.FolderEntity;

public interface FolderDAO {
	public Integer createFolder(FolderEntity path);

	public List<FolderEntity> getFolders();

	public FolderEntity getFolder(Integer id);
}
