package my.catalog.model;

import java.util.List;

import my.catalog.entities.LanguageEntity;

public interface ILanguagesModel extends ILanguagesManager {

	public List<LanguageEntity> getLanguages();

}
