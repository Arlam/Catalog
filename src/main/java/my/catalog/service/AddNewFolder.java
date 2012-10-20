package my.catalog.service;

import java.util.Map;

import my.catalog.dao.AbstractDAOFactory;
import my.catalog.dao.FolderDAO;
import my.catalog.entities.FolderEntity;
import my.catalog.model.IFoldersModel;

import org.apache.log4j.Logger;

public class AddNewFolder {
	private static final Logger LOG = Logger.getLogger(AddNewFolder.class);
	private final static String PATH_PROPERTY = "PATH_VALUE";

	public AddNewFolder(IFoldersModel model) {
	}

	public void call(Map<String, Object> params) {
		FolderDAO folderDAO = AbstractDAOFactory.getActiveDaoFactory()
				.getFolderDAO();
		String path = (String) params.get(PATH_PROPERTY);
		FolderEntity folder = new FolderEntity();
		folder.setFolder(path);
		Integer id = folderDAO.createFolder(folder);
		if (id == null) {
			LOG.info(" skipped.");
		} else {
			LOG.info(" added to BD.");
		}
	}

}
