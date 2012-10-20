package my.catalog.dao;

import java.util.List;

import my.catalog.entities.FilmEntity;

public interface FilmDAO {
	/**
	 * Saves films to DB
	 * 
	 * @param film
	 * @return film id
	 */
	public Integer creatrFilm(FilmEntity film);

	/**
	 * Update film in DB
	 * 
	 * @param film
	 */
	public void updateFilm(FilmEntity film);

	/**
	 * Returns film by id
	 * 
	 * @param id
	 */
	public FilmEntity getFilmById(int id);

	/**
	 * Returns all films
	 * 
	 * @return Returns all films
	 */
	public List<FilmEntity> getAllFilms();

	/**
	 * Deletes film from DB
	 * 
	 * @param film
	 */
	public void delete(FilmEntity film);
}
