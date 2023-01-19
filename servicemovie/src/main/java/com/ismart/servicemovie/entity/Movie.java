package com.ismart.servicemovie.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name="Movie")
	public class Movie {

		@Id
		@GeneratedValue
		private Integer id;
		private String title;
		private Integer year;
		private Double overAllRating;
		private String description;
		private String director;
		private String language;
			
		public Movie() {}

		public Movie(Integer id,String title, Integer year,
				Double overAllRating, String description, String director, String languages) {
			this.id=id;
			this.title = title;
			this.year = year;
			this.overAllRating=overAllRating;
			this.description = description;
			this.director = director;
			this.language = languages;
		}
		

		public Integer getId() {
			return id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		

		public Integer getYear() {
			return year;
		}

		public void setYear(Integer year) {
			this.year = year;
		}
		
		public Double getOverAllRating() {
			return overAllRating;
		}

		public void setOverAllRating(Double overAllRating) {
			this.overAllRating = overAllRating;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getDirector() {
			return director;
		}

		public void setDirector(String director) {
			this.director = director;
		}

		public String getLanguage() {
			return language;
}

		public void setLanguage(String language) {
			this.language = language;
		}

		public Integer findById(int id2) {
			// TODO Auto-generated method stub
			return null;
		}

		public void add(Movie movie) {
			// TODO Auto-generated method stub
			
		}
}
