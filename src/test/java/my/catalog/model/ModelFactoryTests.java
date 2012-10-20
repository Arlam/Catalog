package my.catalog.model;

import static org.junit.Assert.*;
import org.junit.Test;


public class ModelFactoryTests {
	
	@Test
	public void testFactory() {
		IAppModel factory = new AppModel();
		assertEquals(FilmsModel.class, factory.getFilmsModel().getClass());
		assertEquals(FoldersModel.class, factory.getFoldersModel().getClass());
	}
}
