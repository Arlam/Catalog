package my.catalog.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "films", uniqueConstraints = { @UniqueConstraint(columnNames = { "path" }) })
public class FilmEntity implements IEntity, Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name", length = 255)
	private String name;

	@Column(name = "version", length = 32)
	private String version;

	@Column(name = "fileSize")
	private Integer fileSize;

	@Column(name = "year")
	private Integer year;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "films_languages", joinColumns = { @JoinColumn(name = "id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "language_id", nullable = false, updatable = false) })
	private Set<LanguageEntity> languages;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "films_genres", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = { @JoinColumn(name = "ganre_id") })
	private Set<GenreEntity> genres;

	@Column(name = "description")
	private String description;

	@Column(name = "rate")
	private Integer rating;

	@Column(name = "watched")
	private Boolean watched;

	@Column(name = "existed")
	private Boolean existed;

	@Column(name = "path", length = 255, unique = true)
	private String path;

	public FilmEntity() {
		watched = false;
		existed = false;
	}

	// Getters and setters

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Set<LanguageEntity> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<LanguageEntity> languages) {
		this.languages = languages;
	}

	public Set<GenreEntity> getGenres() {
		return genres;
	}

	public void setGenres(Set<GenreEntity> genres) {
		this.genres = genres;
	}

	public Boolean getWatched() {
		return watched;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRate() {
		return rating;
	}

	public void setRate(Integer rate) {
		this.rating = rate;
	}

	public Boolean isWatched() {
		return watched;
	}

	public void setWatched(Boolean watched) {
		this.watched = watched;
	}

	public Boolean getExisted() {
		return existed;
	}

	public void setExisted(Boolean existed) {
		this.existed = existed;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
