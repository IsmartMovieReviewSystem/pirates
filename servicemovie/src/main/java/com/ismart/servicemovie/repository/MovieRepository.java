package com.ismart.servicemovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ismart.servicemovie.entity.Movie;
import com.ismart.servicemovie.entity.Review;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	public Movie findByTitle(String title);

	public Object findById(Movie movie);

	public Object findById(Review review);


}
