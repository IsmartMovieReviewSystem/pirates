package com.ismart.servicemovie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ismart.servicemovie.entity.Movie;
import com.ismart.servicemovie.entity.Review;
import com.ismart.servicemovie.repository.MovieRepository;
import com.ismart.servicemovie.repository.ReviewRepository;
import com.ismart.servicemovie.service.MovieReviewService;

@SpringBootTest(classes= {ServiceMockitoTests.class})

public class ServiceMockitoTests {
	@Mock
	
	ReviewRepository reviewRepository;

	@Mock
	MovieRepository movieRepository;
	@InjectMocks
	MovieReviewService service;
	public List<Movie> mymovies;

	@Test
	@Order(1)
	public void test_getAllMovies()
	{

		List<Movie> mymovies=new ArrayList<Movie>();
		mymovies.add(new Movie(1,"HIT2",2022,4.3,"thriller","abc","Telugu"));
		mymovies.add(new Movie(2,"HIT",2019,4.2,"thriller","abc","Telugu"));

		when(movieRepository.findAll()).thenReturn(mymovies);
		assertEquals(2,service.getAllMovies().size());
	}
	@Test @Order(2)
	public void test_getAllReviewsByMovieTitle() {
		List<Review> reviews=new ArrayList<Review>();
		String title = "Hit2";
		when(reviewRepository.findAll()).thenReturn(reviews);
		assertEquals(title,  service.getAllReviewsByMovieTitle(title).size());
}
	@Test @Order(3)
	public void test_addMovie(){
		try
	{

		Movie movie=new Movie(11,"MR.Majunu",2021,3.9,"Action","def","Telugu");
		when (movieRepository.save(movie)).thenReturn(movie);
		assertEquals(movie,service.addMovie(movie));
		}
	catch(NullPointerException e)        {            
	    System.out.print("NullPointerException Caught");        
	    }
}
	
	
	@Test 
	@Order(4)
	public void test_addReview()
	{ try {
		
	
	when (reviewRepository.save(null)).thenReturn(reviewRepository);
	service.addReview((Review) reviewRepository);
	}
	catch(NullPointerException e)        {            
	    System.out.print("NullPointerException Caught");        
	    }
	}
	
	
	
	@Test 
	
	
	@Order(5)
	public void test_deleteMovie() {
		Movie movie=new Movie(11,"MR.Majunu",2021,3.9,"Action","def","Telugu");
		assertEquals(service.deleteMovie(movie));
		verify(movieRepository,times(1)),delete(movie);
}
	@Test
	@Order(6)
	public void test_getMovieDetailsById() {
		
		Object result = null;
		Movie movie = (Movie) List.of(result);

		movie.add(new Movie(1,"HIT2",2022,4.3,"thriller","abc","Telugu"));
        int id=1;
        when(movieRepository.findAll()).thenReturn((List<Movie>) movie);
        
		assertEquals(id,((Movie) service.getMovieDetailsById(id)).findById(id));


		
		
	}
	
}
		




   
	


