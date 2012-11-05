package my.catalog.service;

import java.io.File;
import java.util.List;

import my.catalog.dao.AbstractDAOFactory;
import my.catalog.entities.FilmEntity;
import my.catalog.entities.FolderEntity;
import my.catalog.model.IAppModel;
import my.catalog.utils.Utility;

import org.apache.log4j.Logger;

public class ScanFoldersController {
	private static final Logger LOG = Logger
			.getLogger(ScanFoldersController.class);
	private final static String REGEX = ".*\\.avi";
	private IAppModel model;

	public ScanFoldersController(IAppModel model) {
		this.model = model;
	}

	public void runScanning() {
		AbstractDAOFactory factory = AbstractDAOFactory.getActiveDaoFactory();
		List<FolderEntity> pathEntities = factory.getFolderDAO().getFolders();
		for (FolderEntity pathEntity : pathEntities) {
			List<File> files = Utility.find(pathEntity.getFolder(), REGEX);
			for (File file : files) {
				FilmEntity film = Utility.fileToFIlm(file);
				Integer id = factory.getFilmDAO().creatrFilm(film);
				if (id == null) {
					LOG.info(film.getName() + " skipped.");
				} else {
					model.getFilmsModel().addFilm(
							factory.getFilmDAO().getFilmById(id));
					LOG.info(film.getName() + " added to BD.");
				}
			}
		}
	}
}
