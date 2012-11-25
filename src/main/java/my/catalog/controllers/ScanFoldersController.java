package my.catalog.controllers;

import java.io.File;
import java.util.List;

import my.catalog.dao.IFolderDAO;
import my.catalog.dao.IMovieDAO;
import my.catalog.entities.FilmEntity;
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
	private IMovieDAO movieDAO;

	public ScanFoldersController() {
	}

	public void setModel(IAppModelFactory model) {
		this.model = model;
	}

	public void runScanning() {
		List<FolderEntity> pathEntities = folderDAO.getAll();
		for (FolderEntity pathEntity : pathEntities) {
			List<File> files = Utility.find(pathEntity.getFolder(), REGEX);
			for (File file : files) {
				try {
					FilmEntity film = Utility.fileToFIlm(file);
					Integer id = movieDAO.add(film);
					if (id != null) {
						model.getFilmsModel().add(movieDAO.get(id));
						LOG.info("Added new film: " + film.getName()); //$NON-NLS-1$
					}
				} catch (HibernateException e) {
					// TODO AA: add check before create record
				}
			}
		}
	}
}
