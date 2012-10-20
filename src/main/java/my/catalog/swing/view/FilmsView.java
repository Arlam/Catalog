package my.catalog.swing.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import my.catalog.model.IAppModel;
import my.catalog.swing.actions.AbstractMenuButton;
import my.catalog.swing.actions.ExitButton;
import my.catalog.swing.actions.ShowFoldersButton;
import my.catalog.swing.adapters.FilmsTableModel;

public class FilmsView extends JFrame {

	private static final long serialVersionUID = -2575244459991309147L;

	private static final int DEFAULT_WIDTH = 1100;
	private static final int DEFAULT_HEIGHT = 800;

	public FilmsView(IAppModel modelsFactory) {
		// temporary for tests
		// AddNewFolder newFolderController = new AddNewFolder(
		// RootModel.getFoldersModel());
		// Map<String, Object> params = new HashMap<String, Object>();
		// params.put("PATH_VALUE", "E://Films");
		// newFolderController.call(params);
		// -----

		// ScanFoldersController scanFoldersController = new
		// ScanFoldersController(
		// modelsFactory);
		// scanFoldersController.call(null);

		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Catalog");
		setLocationRelativeTo(null);

		Container toolbar = createToolBar(modelsFactory);

		add(toolbar, BorderLayout.NORTH);

		TableModel tableModel = new FilmsTableModel(modelsFactory);
		JTable table = new JTable(tableModel);
		// TableColumn watchColumn = table.getColumnModel().getColumn(5);
		// watchColumn.setCellRenderer(new ComboBoxRenderer(new String[] {
		// "true",
		// "false" }));
		// watchColumn.setCellEditor(new ComboBoxEditor());
		add(new JScrollPane(table));

		setColumnsSize(table);
	}

	private void setColumnsSize(JTable table) {
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setMinWidth(350);

	}

	private Container createToolBar(IAppModel factory) {
		Container toolbar = new Container();
		FlowLayout containerLayout = new FlowLayout();
		containerLayout.setAlignment(FlowLayout.LEFT);
		toolbar.setLayout(containerLayout);

		AbstractMenuButton exitButton = new ExitButton(this);
		ShowFoldersButton showAdmFoldersButton = new ShowFoldersButton(this,
				factory);

		toolbar.add(exitButton);
		toolbar.add(showAdmFoldersButton);
		return toolbar;
	};

}
