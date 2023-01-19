package com.ismart.servicemovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ismart.servicemovie.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	public Movie findByTitle(String title);

}
