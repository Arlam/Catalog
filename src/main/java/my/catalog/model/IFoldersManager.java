package my.catalog.model;

import java.util.List;

import my.catalog.entities.FolderEntity;

public interface IFoldersManager {
	public void setData(List<FolderEntity> folders);

	public void addFolder(FolderEntity folder);
}
