package my.catalog.swing.actions;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

public class ExitButton extends AbstractMenuButton {
	private static final long serialVersionUID = -7447181217367553166L;
	private static final String TOOL_TIP = "exit";
	private static final String IMG_NAME = "exit.png";
	private JFrame frame;
		
	public ExitButton(JFrame frame) {
		super(TOOL_TIP, IMG_NAME);
		this.frame = frame;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	}


}
