package my.catalog.swing.actions;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import my.catalog.comparators.NameComparator;
import my.catalog.comparators.RateComparator;
import my.catalog.comparators.WatchStateComparator;
import my.catalog.comparators.YearComparator;
import my.catalog.controllers.FilmsSorter;
import my.catalog.entities.FilmEntity;
import my.catalog.model.SortableModel;

public class TableHeaderOnClickListener extends MouseAdapter {
	private FilmsSorter filmsSorter = new FilmsSorter();
	private SortableModel<FilmEntity> model;
	private boolean[] sortingStates;

	public TableHeaderOnClickListener(SortableModel<FilmEntity> model,
			boolean[] sortingStates) {
		this.model = model;
		this.sortingStates = sortingStates;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JTable table = ((JTableHeader) e.getSource()).getTable();
		TableColumnModel colModel = table.getColumnModel();
		int columnModelIndex = colModel.getColumnIndexAtX(e.getX());
		int modelIndex = colModel.getColumn(columnModelIndex).getModelIndex();
		if (modelIndex < 0) {
			return;
		}
		boolean currentState = !sortingStates[modelIndex];

		switch (modelIndex) {
		case 1:
			filmsSorter.sortByColumn(model, new NameComparator(currentState));
			break;
		case 2:
			filmsSorter.sortByColumn(model, new YearComparator(currentState));
			break;
		case 4:
			filmsSorter.sortByColumn(model, new RateComparator(currentState));
			break;
		case 5:
			filmsSorter.sortByColumn(model, new WatchStateComparator(
					currentState));
			break;
		}
		saveOrderState(modelIndex, currentState);
	}

	private void saveOrderState(int modelIndex, boolean currentState) {
		for (int i = 0; i < sortingStates.length; i++) {
			sortingStates[i] = false;
		}
		sortingStates[modelIndex] = currentState;
	}
}
