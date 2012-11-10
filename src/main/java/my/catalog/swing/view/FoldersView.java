package my.catalog.swing.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import my.catalog.entities.FolderEntity;
import my.catalog.model.IAppModelFactory;
import my.catalog.model.impl.ServerSideDataModel;
import my.catalog.service.FoldersController;
import my.catalog.swing.adapters.FoldersListModel;

import org.apache.log4j.Logger;

public class FoldersView extends JDialog {
	private static final Logger LOG = Logger.getLogger(FoldersView.class);
	private static final long serialVersionUID = -3287258340585248456L;
	private static final String TITLE = "Configuration of input paths"; //$NON-NLS-1$
	private ServerSideDataModel<FolderEntity> model;
	private FoldersView view = this;
	private FoldersController newFolderController;

	private JList listOfFolders;

	private JFileChooser fileChooser = new JFileChooser();

	private ActionListener openDirListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int returnVal = fileChooser.showOpenDialog(view);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				FolderEntity folder = new FolderEntity();
				File file = fileChooser.getSelectedFile();
				folder.setFolder(file.getAbsolutePath());
				newFolderController.addNewFolder(folder);
				listOfFolders.updateUI();
			}
		}
	};

	public FoldersView(JFrame owner, IAppModelFactory modelsFactory) {
		super(owner, TITLE, true);
		this.model = modelsFactory.getFoldersModel();
		this.newFolderController = new FoldersController(modelsFactory);
		this.fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		FoldersListModel listModel = new FoldersListModel(model);
		listOfFolders = new JList(listModel);

		setSize(250, 250);
		setResizable(false);
		setLocationRelativeTo(owner);

		add(listOfFolders, BorderLayout.CENTER);
		JPanel panel = new JPanel();

		JButton newFolderBtn = new JButton("Add new folder"); //$NON-NLS-1$
		panel.add(newFolderBtn, BorderLayout.WEST);
		newFolderBtn.addActionListener(openDirListener);

		// JButton saveFolderBtn = new JButton("Save");
		// saveFolderBtn.addActionListener(saveBtnListener);
		// panel.add(saveFolderBtn, BorderLayout.EAST);

		add(panel, BorderLayout.SOUTH);

		setVisible(true);
	}

}
