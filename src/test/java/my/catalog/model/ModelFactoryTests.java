package my.catalog.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ModelFactoryTests {

	@Test
	public void testFactory() {
		IAppModel factory = new AppModel();
		assertEquals(FilmsModel.class, factory.getFilmsModel().getClass());
		assertEquals(FoldersModel.class, factory.getFoldersModel().getClass());
	}
}
