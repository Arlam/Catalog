package my.catalog.service;

import my.catalog.dao.AbstractDAOFactory;
import my.catalog.dao.GenericDAO;
import my.catalog.entities.FolderEntity;
import my.catalog.model.IAppModelFactory;

import org.apache.log4j.Logger;

public class FoldersController {
	private static final Logger LOG = Logger.getLogger(FoldersController.class);
	private IAppModelFactory model;

	public FoldersController(IAppModelFactory model) {
		this.model = model;
	}

	public void addNewFolder(FolderEntity folder) {
		GenericDAO<FolderEntity> folderDAO = AbstractDAOFactory
				.getActiveDaoFactory().getFolderDAO();
		Integer id = folderDAO.add(folder);
		if (id == null) {
			LOG.info(" skipped.");
		} else {
			model.getFoldersModel().add(folderDAO.get(id));
			LOG.info(" added to BD.");
		}
	}

}
