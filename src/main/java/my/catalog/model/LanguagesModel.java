package my.catalog.model;

import java.util.ArrayList;
import java.util.List;

import my.catalog.entities.LanguageEntity;

public class LanguagesModel implements ILanguagesModel {
	private List<LanguageEntity> languages = new ArrayList<LanguageEntity>();

	@Override
	public void setData(List<LanguageEntity> languages) {
		this.languages = languages;
	}

	@Override
	public List<LanguageEntity> getLanguages() {
		return languages;
	}

}
