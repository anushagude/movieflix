package com.netflix.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table
public class Ratings {

	@Id
	@Column(name = "ratingId")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String ratingsId;
	
	
	
	private String metaScore;
	private String imdbRating;
	private String imdbVotes;
	private String imdbID;
	
	public String getRatingsId() {
		return ratingsId;
	}
	public void setRatingsId(String ratingsId) {
		this.ratingsId = ratingsId;
	}
	public String getMetaScore() {
		return metaScore;
	}
	public void setMetaScore(String metaScore) {
		this.metaScore = metaScore;
	}
	public String getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
		
	@Override
	public String toString() {
		return "Ratings [ratingsId=" + ratingsId + ", metaScore=" + metaScore + ", imdbRating=" + imdbRating
				+ ", imdbVotes=" + imdbVotes + ", imdbID=" + imdbID + "]";
	}
	
	
}
