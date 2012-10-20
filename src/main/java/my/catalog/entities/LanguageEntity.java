package my.catalog.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "languages")
public class LanguageEntity {
	@Id
	@Column(name = "language_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "short_name")
	private String shortName;

	@ManyToMany(mappedBy = "languages")
	private Set<FilmEntity> films;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Set<FilmEntity> getFilms() {
		return films;
	}

	public void setFilms(Set<FilmEntity> films) {
		this.films = films;
	}

}
