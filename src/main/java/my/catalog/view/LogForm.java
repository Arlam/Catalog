package my.catalog.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import my.catalog.entities.IFilm;

public class LogForm extends JDialog {
 
	private static final long serialVersionUID = 7493472155967153866L;
	IFilm r = null;
	public LogForm(JFrame owner, Object o){
		super(owner,"Log", true);
		r = (IFilm)o;
		JList<?> list = r.getLogList();
		JScrollPane sp = new JScrollPane(list);
		add(sp);
		JButton okBtn = new JButton("Ok");
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		Container c = new Container(); 
		c.setLayout(new FlowLayout());
		c.add(okBtn);
		add(c, BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(owner);
		setVisible(true);
	}
}
