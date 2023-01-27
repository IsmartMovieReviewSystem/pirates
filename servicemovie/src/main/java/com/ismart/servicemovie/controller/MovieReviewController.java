package com.ismart.servicemovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismart.servicemovie.entity.Movie;
import com.ismart.servicemovie.entity.Review;
import com.ismart.servicemovie.service.MovieReviewService;

@RestController
@RequestMapping(value="/ismart")
public class MovieReviewController {
	@Autowired
	private MovieReviewService service;
	
	
	//To get all movies
	@GetMapping("/movies")
	public List<Movie> getAllMovies(){
		return service.getAllMovies();
	}
	
	//Get a movie by Id
	@GetMapping("/movies/{id}")
	public Movie getMovieById(@PathVariable Integer id) {
		return service.getMovieDetailsById(id);
	}
	
	//To add a new movie
	@PostMapping("/movies/addMovie")
	public Movie addMovie(@RequestBody Movie movie) {
		return service.addMovie(movie);
	}
	
	//To delete a movie
	@DeleteMapping("/movies/removeMovie/{id}")
	public String removeMovie(@PathVariable Integer id) {
		return service.deleteMovie(id);
	}
	
	//TO Get a review By Id
	@GetMapping("/reviews/{id}")
	public Review getMovieReviewById(@PathVariable Integer id){
		return service.getReviewById(id);
	}
	
	
	//Get all reviews of a movie
	@GetMapping("/movies/{title}/reviews")
	public List<Review> getAllMovieReviewsByMovieTitle(@PathVariable String title){
		return service.getAllReviewsByMovieTitle(title);				
	}
	
	//To Add a movie review
	@PostMapping("/movies/{title}/users/{userName}")
	public Review addMovieReview(@RequestBody Review review,
			@PathVariable String title,@PathVariable String userName) {
		return service.addReview(review,title,userName);
	}
	
	//To delete a review
	@DeleteMapping("/reviews/deleteReview/{id}")
	public String deleteReview(@PathVariable Integer id) {
		return service.deleteReview(id);
	}
	
	//To update a review
	@PutMapping("/reviews/updateReview")
	public Review updateMovieReview(@RequestBody Review review) {
		return service.updateReview(review);
	}
	
	//To get All the reviews written by a user
	@GetMapping("/users/reviews/{userName}")
	public List<Review> getAllMovieReviewsByUserName(@PathVariable String userName){
		return service.getAllReviewsByUserName(userName);				
	}

	public void getMovieDetailsById(int movieId) {
		// TODO Auto-generated method stub
		
	}

	public void deleteMovie(int movieId) {
		// TODO Auto-generated method stub
		
	}

}
