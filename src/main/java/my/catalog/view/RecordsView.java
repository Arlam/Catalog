package my.catalog.view;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import my.catalog.Catalog;
import my.catalog.service.CloseProgramAction;
import my.catalog.service.DeleteRecordsAction;
import my.catalog.service.ExitAction;
import my.catalog.service.ExpDataToFile;
import my.catalog.service.NewRecordAction;
import my.catalog.service.PrintDataAction;
import my.catalog.service.RunFileAction;
import my.catalog.service.SaveDBAction;
import my.catalog.service.ShowLogAction;
import my.catalog.swing.adapters.FilmsTableModel;


import java.net.URL;

public class RecordsView extends JFrame implements Observer{
	
	private static final long serialVersionUID = -1274907389651320829L;
	private static final int DEFAULT_WIDTH = 800;
	private static final int DEFAULT_HEIGHT = 600;

	private JTextField find1,find2,find3, find4;
	private JComboBox find5, find6;
	private Container contFilter;
	//private DBConnector db = null;
	private AbstractTableModel tableModel = new FilmsTableModel(Catalog.getDB());
	private JTable table = new JTable(tableModel);
	private TableRowSorter<AbstractTableModel> sorter = null;
	private RowFilter<AbstractTableModel,Integer> myFilter = null; 
	private JPopupMenu popupMenu = new JPopupMenu();
	
	/**
	 * Controllers
	 */
	private ActionListener newRecordCommand = new NewRecordAction(this);
	private ActionListener saveDBCommand =  new SaveDBAction(); 
	private ActionListener deleteRecordsCommand = new DeleteRecordsAction(this, table);
	private ActionListener printTableComand = new PrintDataAction(this, table);
	private ActionListener showLogCommand = new ShowLogAction(this, table);
	private ActionListener expDataCommand = new ExpDataToFile(this, table);
	private ActionListener runFileCommand = new RunFileAction(this, table);
	private ActionListener closeProgramCommand = new CloseProgramAction();
	
	class MyButton extends JButton {
		private static final long serialVersionUID = -2194363753021584056L;
		public MyButton(String toolTipText,int iventId, URL url) {
			super();
			setToolTipText(toolTipText);
			if(url != null){
				setIcon(new ImageIcon(url));	
			}
			setMargin(new Insets(0, 0, 0, 0));
			setIconTextGap(0);
			setBorderPainted(false);
			setBorder(null);
			if(iventId != -1)
				addActionListener(new MyActionListener(iventId));
			setPreferredSize(new Dimension(32, 32));
		}
	} 
	
	class MyActionListener implements ActionListener {
		int eventId;
		/**
		 * 
		 * @param eventId 0 - newRecord; 1 - sasveRecord; 2 - deleteRecord; 
		 * 3 - filterData; 4 - printData; 5 - exportData; 6 - exitFromProgram; 
		 * 7 - about; 8 - Show log; 9 - run file
		 */
		private MyActionListener(int eventId) {
			this.eventId = eventId;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(eventId){
			case 3:
				filterData();
				break;
			case 7: 
				showAbout();
				break;
			}
		}
		
	}
	
	class MyMouseListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			showPopup(e);	
		}

		public void mouseReleased(MouseEvent e) {
			showPopup(e);	
		}

		private void showPopup(MouseEvent e) {
			if (e.isPopupTrigger()) {
				popupMenu.show(e.getComponent(), e.getX(), e.getY());
			}
		}
	}

	
	public RecordsView() {

		addWindowListener(new ExitAction());
		initData();
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Catalog");
		setLocationRelativeTo(null);
		table.setFillsViewportHeight(true);
		table.setRowSorter(new TableRowSorter<AbstractTableModel>(tableModel));
		MouseListener popupListener = new MyMouseListener();
		table.addMouseListener(popupListener);
		add(new JScrollPane(table));
		updateTableStructure();
		Container topPanel = new Container();
		topPanel.setLayout(new BorderLayout());
		//functional buttons
		Container cpMenuButton = new Container();
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.LEFT);
		cpMenuButton.setLayout(fl);
		JButton newRecordBtn = new MyButton("New record", -1,
				(getClass().getResource("/images/new.png")));
		newRecordBtn.addActionListener(newRecordCommand);
		cpMenuButton.add(newRecordBtn);
		JButton saveButton = new MyButton("Save changes", -1, 
				(getClass().getResource("/images/save.png")));
		saveButton.addActionListener(saveDBCommand);
		
		cpMenuButton.add(saveButton);
		JButton delButton = new MyButton("Delete record(s)", -1,
				(getClass().getResource("/images/no.png")));
		delButton.addActionListener(deleteRecordsCommand);
		cpMenuButton.add(delButton);
		JButton findBtn = new MyButton("Find record", 3,  
				(getClass().getResource("/images/find.png")));
		cpMenuButton.add(findBtn);
		JButton printBtn = new MyButton("Print data", -1, 
				(getClass().getResource("/images/print.png")));
		printBtn.addActionListener(printTableComand);
		cpMenuButton.add(printBtn);
		JButton exportBtn = new MyButton("Export data", -1,
				(getClass().getResource("/images/redo.png")));
		exportBtn.addActionListener(expDataCommand);
		cpMenuButton.add(exportBtn);
		JButton loadBtn = new MyButton("Run file", -1,
				(getClass().getResource("/images/frames.png")));
		loadBtn.addActionListener(runFileCommand);
		cpMenuButton.add(loadBtn);
		JButton exitBtn = new MyButton("Exit", -1,
				(getClass().getResource("/images/exit.png")));
		exitBtn.addActionListener(closeProgramCommand);
		cpMenuButton.add(exitBtn);
		topPanel.add(cpMenuButton, BorderLayout.NORTH);
		contFilter = createFilter();
		topPanel.add(contFilter,BorderLayout.SOUTH);
		add(topPanel, BorderLayout.NORTH);
		//Menu begin
		JMenuBar topMenu = new JMenuBar();
		setJMenuBar(topMenu);
		JMenu fileMenuItem = new JMenu("File");
		JMenu editMenuItem = new JMenu("Edit");
		JMenu aboutMenuItem = new JMenu("About");
		topMenu.add(fileMenuItem);
		topMenu.add(editMenuItem);
		topMenu.add(aboutMenuItem);
		JMenuItem saveMI = new JMenuItem("Save");
		JMenuItem exportMI = new JMenuItem("Export...");
		JMenuItem printMI = new JMenuItem("Print...");
		JMenuItem exitMI = new JMenuItem("Exit");
		JMenuItem addRecordMI = new JMenuItem("New record");
		JMenuItem deleteRecordsMI = new JMenuItem("Delete record(s)");
		JMenuItem aboutMI = new JMenuItem("About");
		fileMenuItem.add(saveMI);
		fileMenuItem.add(exportMI);
		fileMenuItem.addSeparator();
		fileMenuItem.add(exitMI);
		editMenuItem.add(addRecordMI);
		editMenuItem.add(deleteRecordsMI);
		aboutMenuItem.add(aboutMI);
		exportMI.addActionListener(expDataCommand);
		printMI.addActionListener(printTableComand);
		exitMI.addActionListener(closeProgramCommand);
		addRecordMI.addActionListener(newRecordCommand);
		deleteRecordsMI.addActionListener(deleteRecordsCommand);
		
		aboutMI.addActionListener(new MyActionListener(7));
		//PopUpMenu
		JMenuItem addRecordPMI = new JMenuItem("New record");
		JMenuItem deleteRecordsPMI = new JMenuItem("Delete record(s)");
		JMenuItem exportPMI = new JMenuItem("Export...");
		JMenuItem printPMI = new JMenuItem("Print...");
		JMenuItem runPMI = new JMenuItem("Run file");
		JMenuItem logPMI = new JMenuItem("Log changes");
		addRecordPMI.addActionListener(newRecordCommand);
		deleteRecordsPMI.addActionListener(deleteRecordsCommand);
		exportPMI.addActionListener(expDataCommand);
		printPMI.addActionListener(printTableComand);
		runPMI.addActionListener(runFileCommand);
		logPMI.addActionListener(showLogCommand);
		popupMenu.add(addRecordPMI);
		popupMenu.add(deleteRecordsPMI);
		popupMenu.addSeparator();
		popupMenu.add(exportPMI);
		popupMenu.add(printPMI);
		popupMenu.addSeparator();
		popupMenu.add(runPMI);
		popupMenu.add(logPMI);
	}
	
	private void initData() {
		sorter = new TableRowSorter<AbstractTableModel>(tableModel);
		myFilter = new RowFilter<AbstractTableModel,Integer>() {
			public boolean include(Entry<? extends AbstractTableModel, ?
					extends Integer> entry) {
				if(!entry.getStringValue(0).startsWith(find1.getText())) 
					return false;
				if(!entry.getStringValue(1).startsWith(find2.getText())) 
					return false;
				if(!entry.getStringValue(2).startsWith(find3.getText())) 
					return false;
				if(!entry.getStringValue(3).startsWith(find4.getText())) 
					return false;
				if((!find5.getSelectedItem().equals("all")) &&
						(!entry.getStringValue(4).equals(
								find5.getSelectedItem()))) {
					return false;	
				}
				
				if((!find6.getSelectedItem().equals("")) &&
						(!entry.getStringValue(5).equals(Integer.toString(
								(Integer)find6.getSelectedItem())))){
					return false;
				}
				return true;
			}
		};
	}

	/**
	 * Filter panel
	 */
	private Container createFilter() {
		Container cp = new Container();
		find1 = new JTextField();
		find1.setToolTipText("Name");
		find2 = new JTextField();
		find2.setToolTipText("Year");
		find3 = new JTextField();
		find3.setToolTipText("Category");
		find4 = new JTextField();
		find4.setToolTipText("Description");
		find5 = new JComboBox();
		find5.setToolTipText("Is watched?");
		find5.addItem("all");
		find5.addItem("false");
		find5.addItem("true");
		find6 = new JComboBox();
		find6.setToolTipText("Rate");
		find6.addItem("");
		for(int i = 1; i < 11; i++){
			find6.addItem(i + "");
		}
		cp.setLayout(new GridLayout(1, 6));
		cp.add(find1);
		cp.add(find2);
		cp.add(find3);
		cp.add(find4);
		cp.add(find5);
		cp.add(find6);
		
		return cp;
	}
	
	private void showAbout() {
		new FormAbout(this);
	}
	
	public AbstractTableModel getTableModel(){
		return tableModel;
	}
	
	/**
	 * Գ�����
	 */
	private void filterData() {
		sorter.setRowFilter(myFilter);
		table.setRowSorter(sorter);
		updateTableStructure();
	}
	
	/**
	 * ����������� �������
	 */
	private void updateTableStructure() {
		tableModel.fireTableStructureChanged();
		for(int i = 0; i <  tableModel.getColumnCount(); i++) {
			TableColumn tc = table.getColumnModel().getColumn(i);
			DefaultCellEditor ce = ((FilmsTableModel) tableModel).getCellEditor(i);
			if(ce != null) {
				tc.setCellEditor(ce);	
			} 
		}
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		updateTableStructure();
		
	} 
	
}












