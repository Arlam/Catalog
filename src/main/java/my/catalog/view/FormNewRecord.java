package my.catalog.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import my.catalog.DBConnector;
import my.catalog.entities.FilmRecord;
import my.catalog.entities.IFilm;


public class FormNewRecord extends JDialog {
	//private DBConnector db = null;
	//private AbstractTableModel tm = null;

	private static final long serialVersionUID = 3653537256321361331L;
	
	public FormNewRecord(JFrame frame, final DBConnector db) {
		super(frame,"New record", true);
		setResizable(false);
		setLayout(new GridLayout(8,2));
		add(new JLabel("����� ������:"));
		final JTextField nameTextF = new JTextField();
		add(nameTextF);
		add(new JLabel("г�:"));
		final JFormattedTextField yearTextF = 
			new JFormattedTextField(createFormatter("####"));
		add(yearTextF);
		add(new JLabel("����:"));
		final JTextField genreTextF = new JTextField();
		add(genreTextF);
		add(new JLabel("����:"));
		final JTextField descriptionTextArea = new JTextField();
		add(descriptionTextArea);
		add(new JLabel("���� (�� ���������������):"));
		final JTextField pathTextF = new JTextField();
		add(pathTextF);
		add(new JLabel("�����:"));
		final JCheckBox watchedCheckBox = new JCheckBox();
		add(watchedCheckBox);
		add(new JLabel("�������:"));
		final JComboBox<Integer> rateComboBox = new JComboBox<Integer>();
		for(int i = 1; i<=10; i++) {
			rateComboBox.addItem(i);	
		}
		
		add(rateComboBox);
		JButton okButton = new JButton("��������");
		add(okButton);
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				IFilm record = new FilmRecord(nameTextF.getText(),
						yearTextF.getText(),
						genreTextF.getText(),
						descriptionTextArea.getText(),
						watchedCheckBox.isSelected(), 
						(Integer) rateComboBox.getItemAt(rateComboBox.getSelectedIndex()),
						pathTextF.getText()
				); 
				System.out.println(db.addNewRecord(record));
				System.out.println(db.getRecordsCount());
				dispose();
			}
		});
		JButton escapeButton = new JButton("³������");
		add(escapeButton);
		
		escapeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		pack();
		setLocationRelativeTo(frame);
		setVisible(true);
	}
	
	protected MaskFormatter createFormatter(String s) {
	    MaskFormatter formatter = null;
	    try {
	        formatter = new MaskFormatter("HHHH");
	        formatter.setValidCharacters(" 0123456789");
	        formatter.setPlaceholder("");
	    } catch (java.text.ParseException exc) {
	        System.err.println("formatter is bad: " + exc.getMessage());
	        System.exit(-1);
	    }
	    return formatter;
	}
}
