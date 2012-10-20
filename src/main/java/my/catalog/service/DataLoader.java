package my.catalog.service;

import java.util.Map;

import my.catalog.dao.AbstractDAOFactory;
import my.catalog.model.IAppModel;

public class DataLoader extends AbstractController {
	IAppModel model;
	AbstractDAOFactory abstractDAOFactory;

	public DataLoader(IAppModel model, AbstractDAOFactory abstractDAOFactory) {
		super(model, abstractDAOFactory);
		this.abstractDAOFactory = abstractDAOFactory;
	}

	@Override
	public void call(Map<String, Object> params) {
		updateFilmsModel();
	}

	public void updateAllModels() {
		updatePathsModel();
		updateLanguageModel();
		updateGanreModel();
		updateFilmsModel();
	}
}
