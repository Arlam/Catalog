package my.catalog.model;

import static org.junit.Assert.assertEquals;
import my.catalog.model.impl.AppModelFactory;
import my.catalog.model.impl.ServerSideDataModel;

import org.junit.Test;

public class ModelFactoryTests {

	@Test
	public void testFactory() {
		IAppModelFactory factory = new AppModelFactory();
		assertEquals(ServerSideDataModel.class, factory.getFilmsModel()
				.getClass());
		assertEquals(ServerSideDataModel.class, factory.getFoldersModel()
				.getClass());
	}
}
