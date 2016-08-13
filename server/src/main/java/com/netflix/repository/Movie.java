package com.netflix.repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Movie.findAll", query = "SELECT e FROM Movie e")})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "movie_id")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(generator = "uuid")
	private String id;

	private String titleName;
	private String year;
	private Date released;
	private String runTime;
	private String director;
	private String writer;
	private String actors;
	private String plot;
	private String awards;
	private String poster;
	private String Type;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ratingId")
	private Ratings ratings;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
	@JsonManagedReference
	private List<Country> country;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
	@JsonManagedReference
	private List<Genre> genre;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Date getReleased() {
		return released;
	}

	public void setReleased(Date released) {
		this.released = released;
	}

	public String getRunTime() {
		return runTime;
	}

	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Ratings getRatings() {
		return ratings;
	}

	public void setRatings(Ratings ratings) {
		this.ratings = ratings;
	}

	public List<Country> getCountry() {
		return country;
	}

	public void setCountry(List<Country> country) {
		this.country = country;
	}

	public List<Genre> getGenre() {
		return genre;
	}

	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", titleName=" + titleName + ", year=" + year + ", released=" + released
				+ ", runTime=" + runTime + ", director=" + director + ", writer=" + writer + ", actors=" + actors
				+ ", plot=" + plot + ", awards=" + awards + ", poster=" + poster + ", Type=" + Type + ", ratings="
				+ ratings + ", country=" + country + ", genre=" + genre + "]";
	}

}
