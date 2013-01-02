package my.catalog.entities;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "files")
public class FileEntity implements IEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne()
	@JoinColumn(name = "film_id", nullable = true)
	private FilmEntity film;

	@Column(name = "path", length = 255, unique = true)
	private String path;

	@Column(name = "fileSize")
	private Integer fileSize;

	public FileEntity() {
		// TODO Auto-generated constructor stub
	}

	public FileEntity(File file) {
		path = file.getAbsolutePath();
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	public FilmEntity getFilm() {
		return film;
	}

	public void setFilm(FilmEntity film) {
		this.film = film;
	}

}
