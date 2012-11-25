package my.catalog;

import javax.swing.JFrame;

import my.catalog.controllers.DataLoader;
import my.catalog.controllers.ScanFoldersController;
import my.catalog.model.IAppModelFactory;
import my.catalog.model.impl.AppModelFactory;
import my.catalog.swing.view.FilmsView;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Catalog {
	private static ApplicationContext context;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("BeanLocations.xml");
		IAppModelFactory model = new AppModelFactory();
		DataLoader dataLoader = context.getBean(DataLoader.class);
		dataLoader.setAppModel(model);
		dataLoader.updateAllModels();

		ScanFoldersController scaner = context
				.getBean(ScanFoldersController.class);
		scaner.setModel(model);
		scaner.runScanning();
		JFrame catalog = new FilmsView(model, context);
		catalog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		catalog.setVisible(true);
	}

}
