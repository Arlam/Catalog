package my.catalog.swing.adapters;

import javax.swing.table.AbstractTableModel;

import my.catalog.entities.FilmEntity;
import my.catalog.model.IAppModel;
import my.catalog.model.IFilmsModel;
import my.catalog.service.FilmController;

public class FilmsTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 7164003784495156620L;

	private IFilmsModel filmsModel;
	private FilmController filmController;

	public FilmsTableModel(IAppModel models) {
		this.filmsModel = models.getFilmsModel();
		this.filmController = new FilmController(models);
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return filmsModel.getFilms().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		FilmEntity film = filmsModel.getFilms().get(rowIndex);
		switch (columnIndex) {
		case 0:
			return rowIndex + 1;
		case 1:
			return film.getName();
		case 2:
			return film.getYear();
		case 3:
			return film.getLanguages();
		case 4:
			return film.getRate();
		case 5:
			return film.isWatched();
		case 6:
			return film.getPath();
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 5:
			return Boolean.class;
		}
		return super.getColumnClass(columnIndex);
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "№";
		case 1:
			return "Name";
		case 2:
			return "Year";
		case 3:
			return "Languages";
		case 4:
			return "Rate";
		case 5:
			return "Watched";
		case 6:
			return "Path";
		}
		return super.getColumnName(columnIndex);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			return true;
		default:
			return false;
		}
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		FilmEntity film = filmsModel.getFilm(rowIndex);
		switch (columnIndex) {
		case 1:
			film.setName((String) value);
			break;
		case 5:

			film.setWatched((Boolean) value);
			break;

		}
		filmController.updateFilm(film);
	}
}
