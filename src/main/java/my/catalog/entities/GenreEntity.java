package my.catalog.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class GenreEntity implements IEntity, Serializable {
	private static final long serialVersionUID = -5191457837781027430L;

	@Id
	@Column(name = "ganre_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "genres")
	private Set<FilmEntity> films;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<FilmEntity> getFilms() {
		return films;
	}

	public void setFilms(Set<FilmEntity> films) {
		this.films = films;
	}

}
