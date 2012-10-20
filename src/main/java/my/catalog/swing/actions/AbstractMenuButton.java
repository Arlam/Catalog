package my.catalog.swing.actions;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class AbstractMenuButton extends JButton implements ActionListener {
	private final static String IMG_FOLDER = "images";
//	private final static String FILE_SEPARATOR =System.getProperty("file.separator");
	private final static String FILE_SEPARATOR ="/";
	private static final long serialVersionUID = -7396432153300953531L;

	public AbstractMenuButton(String name, String imageName) {
		super();
		addActionListener(this);
		URL image = getClass().getResource(FILE_SEPARATOR + IMG_FOLDER + FILE_SEPARATOR + imageName);
		setToolTipText(name);
		if(image != null){
			setIcon(new ImageIcon(image));	
		}
		setMargin(new Insets(0, 0, 0, 0));
		setIconTextGap(0);
		setBorderPainted(false);
		setBorder(null);
		setPreferredSize(new Dimension(32, 32));
	}
}
