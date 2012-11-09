package my.catalog.model;

import static org.junit.Assert.assertEquals;
import my.catalog.model.impl.AppModel;
import my.catalog.model.impl.ServerSideDataModel;

import org.junit.Test;

public class ModelFactoryTests {

	@Test
	public void testFactory() {
		IAppModel factory = new AppModel();
		assertEquals(ServerSideDataModel.class, factory.getFilmsModel()
				.getClass());
		assertEquals(ServerSideDataModel.class, factory.getFoldersModel()
				.getClass());
	}
}
