package my.catalog.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import my.catalog.dao.IFileDAO;
import my.catalog.dao.IFolderDAO;
import my.catalog.entities.FileEntity;
import my.catalog.entities.FolderEntity;
import my.catalog.model.IAppModelFactory;
import my.catalog.utils.Utility;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ScanFoldersController {
	private static final Logger LOG = Logger
			.getLogger(ScanFoldersController.class);
	private final static String REGEX = ".*\\.avi"; //$NON-NLS-1$
	private IAppModelFactory model;

	@Autowired
	private IFolderDAO folderDAO;
	@Autowired
	private IFileDAO fileDAO;

	public ScanFoldersController() {
	}

	public void setModel(IAppModelFactory model) {
		this.model = model;
	}

	public void runScanning() {
		List<FolderEntity> pathEntities = folderDAO.getAll();
		List<File> files = new ArrayList<File>();
		for (FolderEntity pathEntity : pathEntities) {
			files.addAll(Utility.find(pathEntity.getFolder(), REGEX));
		}
		for (File file : files) {
			add(file);
		}
	}

	private void add(File file) {
		FileEntity muvieFile = fileDAO.findByPath(file.getAbsolutePath());
		if (muvieFile == null) {
			try {
				muvieFile = new FileEntity(file);
				fileDAO.add(muvieFile);
				LOG.info("New file was added. File name: " + file.getName());
			} catch (HibernateException e) {
				LOG.error(e.getMessage());
			}
		}
	}
}
