package my.catalog.swing.adapters;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import my.catalog.entities.FolderEntity;
import my.catalog.model.impl.ServerSideDataModel;

public class FoldersListModel implements ListModel {
	private ServerSideDataModel<FolderEntity> model;

	public FoldersListModel(ServerSideDataModel<FolderEntity> model) {
		this.model = model;
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getElementAt(int index) {
		return model.getAll().get(index);
	}

	@Override
	public int getSize() {
		return model.getAll().size();
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

}
