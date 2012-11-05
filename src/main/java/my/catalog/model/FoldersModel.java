package my.catalog.model;

import java.util.ArrayList;
import java.util.List;

import my.catalog.entities.FolderEntity;

public class FoldersModel implements IFoldersModel {
	private List<FolderEntity> folders = new ArrayList<FolderEntity>();

	@Override
	public List<FolderEntity> getFolders() {
		return folders;
	}

	@Override
	public void setData(List<FolderEntity> folders) {
		this.folders = folders;

	}

	@Override
	public void addFolder(FolderEntity folder) {
		for (int i = 0; i < folders.size(); i++) {
			if (folders.get(i).getId() == folder.getId()) {
				folders.set(i, folder);
			}
		}

	}
}
