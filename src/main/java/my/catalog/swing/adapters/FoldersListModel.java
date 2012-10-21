package my.catalog.swing.adapters;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import my.catalog.model.IFoldersModel;

public class FoldersListModel implements ListModel {
	private IFoldersModel model;

	public FoldersListModel(IFoldersModel model) {
		this.model = model;
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getElementAt(int index) {
		return model.getFolders().get(index);
	}

	@Override
	public int getSize() {
		System.out.println(model.getFolders().size());
		return model.getFolders().size();
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

}
