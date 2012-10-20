package my.catalog.swing.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import my.catalog.entities.FolderEntity;
import my.catalog.model.IAppModel;
import my.catalog.model.IFoldersModel;
import my.catalog.service.AddNewFolder;

import org.apache.log4j.Logger;

public class FoldersView extends JDialog {
	private static final Logger LOG = Logger.getLogger(FoldersView.class);
	private static final long serialVersionUID = -3287258340585248456L;
	private static final String TITLE = "Configuration of input paths";
	private IFoldersModel model;
	private FoldersView view = this;

	private JFileChooser fileChooser = new JFileChooser();

	private ActionListener openDirListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int returnVal = fileChooser.showOpenDialog(view);
		}
	};

	private ActionListener saveBtnListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			AddNewFolder newFolderController = new AddNewFolder(model);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("PATH_VALUE", "E://Films");
			newFolderController.call(params);
		}
	};

	public FoldersView(JFrame owner, IAppModel modelsFactory) {
		super(owner, TITLE, true);
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		this.model = modelsFactory.getFoldersModel();
		setSize(250, 250);
		setResizable(false);
		setLocationRelativeTo(owner);
		List<FolderEntity> folders = model.getFolders();
		LOG.debug(folders.size());
		JList listOfFolders = new JList(folders.toArray());
		add(listOfFolders, BorderLayout.CENTER);
		JPanel panel = new JPanel();

		JButton newFolderBtn = new JButton("Add new folder");
		panel.add(newFolderBtn, BorderLayout.WEST);
		newFolderBtn.addActionListener(openDirListener);

		JButton saveFolderBtn = new JButton("Save");
		saveFolderBtn.addActionListener(saveBtnListener);
		panel.add(saveFolderBtn, BorderLayout.EAST);

		add(panel, BorderLayout.SOUTH);

		setVisible(true);
	}

}
