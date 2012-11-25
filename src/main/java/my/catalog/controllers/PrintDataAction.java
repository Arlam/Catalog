package my.catalog.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class PrintDataAction implements ActionListener {
	JFrame frame = null;
	JTable table = null;
	
	public PrintDataAction(JFrame frame, JTable table) {
		this.frame = frame;
		this.table = table;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			table.print();
		} catch (PrinterException er) {
			JOptionPane.showMessageDialog(frame,
					er.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			
		}
	}

}
