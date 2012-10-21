package my.catalog.service;

import my.catalog.dao.AbstractDAOFactory;
import my.catalog.dao.FolderDAO;
import my.catalog.entities.FolderEntity;
import my.catalog.model.IAppModel;

import org.apache.log4j.Logger;

public class FoldersController extends AbstractController {
	private static final Logger LOG = Logger.getLogger(FoldersController.class);

	public FoldersController(IAppModel model) {
		super(model);
	}

	public void addNewFolder(FolderEntity folder) {
		FolderDAO folderDAO = AbstractDAOFactory.getActiveDaoFactory()
				.getFolderDAO();
		Integer id = folderDAO.createFolder(folder);
		if (id == null) {
			LOG.info(" skipped.");
		} else {
			LOG.info(" added to BD.");
		}
		updateFoldersModel();
	}

}
