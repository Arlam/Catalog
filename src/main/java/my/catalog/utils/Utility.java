package my.catalog.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.catalog.entities.FilmEntity;
import my.catalog.entities.LanguageEntity;

import org.apache.log4j.Logger;

public final class Utility {
	private static final Logger LOG = Logger.getLogger(Utility.class);

	public static final List<File> find(String folderName, String regex) {
		List<File> files = new ArrayList<File>();

		File folder = new File(folderName);
		if (folder.isDirectory()) {
			File[] foundFiles = folder.listFiles();
			for (File file : foundFiles) {
				if (file.isDirectory()) {
					files.addAll(find(file.getAbsolutePath(), regex));
				} else {
					if (file.getName().matches(regex)) {
						files.add(file);
					}
				}
			}
		}
		return files;
	}

	public final static FilmEntity fileToFIlm(File file) {
		FilmEntity film = new FilmEntity();
		String fileName = file.getName();

		film.setPath(file.getAbsolutePath());
		film.setName(fileName);
		film.setYear(getYEAR(fileName));
		return film;
	}

	public static Integer getYEAR(String fileName) {
		String REGEX = "\\((.+)\\)";
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(fileName);
		if (matcher.find()) {
			try {
				String year = matcher.group(1);
				return Integer.parseInt(year);
			} catch (NumberFormatException e) {
				LOG.error(e.getMessage());
			}
		}
		return null;
	}

	public LanguageEntity[] getLanguages(String fileName) {
		String REGEX = "\\[(.+?)\\]";
		return null;
	}
}
