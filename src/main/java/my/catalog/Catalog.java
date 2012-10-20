package my.catalog;

import javax.swing.JFrame;

import my.catalog.dao.AbstractDAOFactory;
import my.catalog.dao.FactoryType;
import my.catalog.model.AppModel;
import my.catalog.model.IAppModel;
import my.catalog.service.DataLoader;
import my.catalog.swing.view.FilmsView;

public class Catalog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractDAOFactory.initFactory(FactoryType.MY_SQL_FACTORY);
		IAppModel model = new AppModel();
		DataLoader dataLoader = new DataLoader(model,
				AbstractDAOFactory.getActiveDaoFactory());
		dataLoader.updateAllModels();

		JFrame catalog = new FilmsView(model);
		catalog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		catalog.setVisible(true);
	}

}
