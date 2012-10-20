package my.catalog.swing.actions;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import my.catalog.model.IAppModel;
import my.catalog.swing.view.FoldersView;

public class ShowFoldersButton extends AbstractMenuButton {
	private static final long serialVersionUID = 7257133639407938840L;
	private static final String TOOL_TIP = "Open paths config";
	private static final String IMG_NAME = "AddFolder.png";
	private JFrame owner = null;
	private IAppModel modelsFactory;

	public ShowFoldersButton(JFrame owner, IAppModel factory) {
		super(TOOL_TIP, IMG_NAME);
		this.owner = owner;
		this.modelsFactory = factory;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new FoldersView(owner, modelsFactory);

	}

}
