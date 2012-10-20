package my.catalog.model;

import java.util.List;

import my.catalog.entities.FolderEntity;

public interface IFoldersModel extends IFoldersManager {

	public List<FolderEntity> getFolders();

}
