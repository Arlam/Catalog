package my.catalog.service;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class RunFileAction implements ActionListener {
	JFrame frame = null;
	JTable table = null;
	
	public RunFileAction(JFrame frame, JTable table) {
		this.frame = frame;
		this.table = table;
	}
	
	@Override
	public void actionPerformed(ActionEvent ea) {
		int id = table.getSelectedRow();
		if(id >= 0){
			try {
				execFile((String)table.getValueAt(id, 6));
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame,
						e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(frame,
					"No selected record", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	private void execFile(String absolutePath) throws IOException {
		File file = new File(absolutePath);
		if(file.exists() && file.getAbsolutePath().matches(".*\\.avi")){
			Desktop desktop = null;
			if (Desktop.isDesktopSupported()) {
				try{
					desktop = Desktop.getDesktop();
					desktop.open(file);	
				}catch(IOException e){
					JOptionPane.showMessageDialog(frame,
							e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}else{
			JOptionPane.showMessageDialog(frame,
					"File path is wrong", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
