package my.catalog.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;

public class UtilityTests {
	private static final String FOLDER = "src/test/resources/testFolderWithFilms";
	private static final String EXPECTED_FILE_NAME = "test film.avi";
	private static final String FILE_SEPARATOR = System
			.getProperty("file.separator");
	private String correctFileName = "Тачки (2006) [rus,ua,eng].avi";
	private String wrongNameFormat = "Тачки.avi";

	@Test
	public void testFindFiles() {
		File folder = new File(FOLDER);
		List<File> files = Utility.find(folder.getAbsolutePath(), ".*\\.avi");
		File expectedFileName = new File(FOLDER + FILE_SEPARATOR
				+ EXPECTED_FILE_NAME);
		assertEquals(expectedFileName.getAbsolutePath(), files.get(0)
				.getAbsolutePath());
	}

	@Test
	public void testFileToFilm() {
		String expectedPath = "e://films//name.avi";
		String expectedName = "name.avi";
		File file = EasyMock.createMock(File.class);
		EasyMock.expect(file.getAbsolutePath()).andStubReturn(expectedPath);
		EasyMock.expect(file.getName()).andStubReturn(expectedName);
		EasyMock.replay(file);
		assertEquals(expectedPath, Utility.fileToFIlm(file).getPath());
		assertEquals(expectedName, Utility.fileToFIlm(file).getName());
	}

	@Test
	public void testParseYear() {
		assertEquals(new Integer(2006), Utility.getYEAR(correctFileName));
		assertNull(Utility.getYEAR(wrongNameFormat));
	}
}
