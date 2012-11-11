package my.catalog.swing.adapters;

import javax.swing.table.AbstractTableModel;

import my.catalog.entities.FilmEntity;
import my.catalog.model.IDataProvider;
import my.catalog.model.impl.CurrentSessionDataModel;
import my.catalog.model.impl.ServerSideDataModel;
import my.catalog.service.FilmController;

public class FilmsTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 7164003784495156620L;

	private final IDataProvider<FilmEntity> filmsModel;
	private final FilmController filmController;

	public FilmsTableModel(ServerSideDataModel<FilmEntity> rootModel,
			CurrentSessionDataModel<FilmEntity> filmsModel) {
		this.filmsModel = filmsModel;
		this.filmController = new FilmController(rootModel);
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return filmsModel.getAll().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		FilmEntity film = filmsModel.getAll().get(rowIndex);
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
		case 2:
			return Integer.class;
		case 4:
			return Integer.class;
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
			return "Rating";
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
		FilmEntity film = filmsModel.get(rowIndex);
		switch (columnIndex) {
		case 1:
			film.setName((String) value);
			break;
		case 2:
			film.setYear((Integer) value);
			break;
		case 4:
			Integer rate = (Integer) value;
			if (rate >= 0 && rate < 11)
				film.setRate((Integer) value);
			break;
		case 5:

			film.setWatched((Boolean) value);
			break;

		}
		filmController.updateFilm(film);
	}
}
