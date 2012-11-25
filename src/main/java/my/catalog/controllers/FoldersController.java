package my.catalog.controllers;

import my.catalog.dao.IFolderDAO;
import my.catalog.entities.FolderEntity;
import my.catalog.model.IAppModelFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class FoldersController {
	private static final Logger LOG = Logger.getLogger(FoldersController.class);
	private IAppModelFactory model;
	@Autowired
	private IFolderDAO folderDAO;

	public FoldersController(IAppModelFactory model) {
		this.model = model;
	}

	public void addNewFolder(FolderEntity folder) {
		Integer id = folderDAO.add(folder);
		if (id == null) {
			LOG.info(" skipped.");
		} else {
			model.getFoldersModel().add(folderDAO.get(id));
			LOG.info(" added to BD.");
		}
	}

}
