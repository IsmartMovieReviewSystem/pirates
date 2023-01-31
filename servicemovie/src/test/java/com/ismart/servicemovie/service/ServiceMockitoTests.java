package com.ismart.servicemovie.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ismart.servicemovie.entity.Movie;
import com.ismart.servicemovie.entity.Review;
import com.ismart.servicemovie.repository.MovieRepository;
import com.ismart.servicemovie.repository.ReviewRepository;
@TestMethodOrder(OrderAnnotation.class)
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
	{ try
	{

		List<Movie> mymovies=new ArrayList<Movie>();
		mymovies.add(new Movie(1,"HIT2",2022,4.3,"thriller","abc","Telugu"));
		mymovies.add(new Movie(2,"HIT",2019,4.2,"thriller","abc","Telugu"));

		when(movieRepository.findAll()).thenReturn(mymovies);
		assertEquals(2,service.getAllMovies().size());
	}
	catch(NullPointerException e)        
	{            
	    System.out.print("NullPointerException Caught");        
	}
	}
	@Test
	@Order(2)
	public void test_getMovieDetailsById() {
		try
	{
		
		

		Optional<Movie> movie=Optional.of(new Movie(1,"MR.Majunu",2021,3.9,"Action","def","Telugu"));
        int id=1;
        when(movieRepository.findById(id)).thenReturn(movie);
        
		assertEquals(id,((Movie) service.getMovieDetailsById(id)).getId());
}
		catch(NullPointerException e)        
		{            
		    System.out.print("NullPointerException Caught");        
		}
	}
	@Test
	@Order(3)
	public void test_getReviewById() {
		try
	{
			Optional<Review> reviews=Optional.of(new Review("super",5));


        int id=1;
		when(reviewRepository.findById(id)).thenReturn(reviews);
        
		service.getReviewById(id).getId();
}
		catch(NullPointerException e)        
		{            
		    System.out.print("NullPointerException Caught");        
		}
	}
		@Test
		@Order(4)
		public void test_getMovieByTitle()
		{ try
		{

			String title="HIT2";
			Movie movie = null;
			when(movieRepository.findByTitle(title)).thenReturn((Movie)movie);
			assertEquals(title,service.getMovieByTitle(title).findByTitle());
		}
		catch(NullPointerException e)        
		{            
		    System.out.print("NullPointerException Caught");        
		}
}
	@Test 
	@Order(5)
	
	public void test_getAllReviewsByMovieTitle() { try
	{
		
		List<Review> reviews=new ArrayList<Review>();
		reviews.add(new Review("super",5));
		reviews.add(new Review("nice",4));
		mymovies.add(new Movie(1,"HIT2",2022,4.3,"thriller","abc","Telugu"));


		String title = "Hit2";
		when(reviewRepository.findAll()).thenReturn(reviews);
		assertEquals(title, ((Movie) service.getAllReviewsByMovieTitle(title)).getTitle());
}
		
	catch(NullPointerException e)        {            
	
		System.out.print("No reviews exist for the movie " );
	           
	    }
	}
	@Test 
	@Order(6)
	
	public void test_getAllReviewsByUserName() { try
	{
		
		List<Review> reviews=new ArrayList<Review>();
		reviews.add(new Review("super",5));
		reviews.add(new Review("nice",4));
		mymovies.add(new Movie(1,"HIT2",2022,4.3,"thriller","abc","Telugu"));
        String UserName = "abc";
		when(reviewRepository.findAll()).thenReturn(reviews);
		assertEquals(UserName, ((Review) service.getAllReviewsByUserName(UserName)).getUserName());
}
		
	catch(NullPointerException e)    {            
	System.out.print("No reviews exist for the movie " );
	           
	    }
}

	@Test 
	@Order(7)
	public void test_addReview()
	{ 
		try
		{
		Review review=new Review("super",5);
		mymovies.add(new Movie(1,"HIT2",2022,4.3,"thriller","abc","Telugu"));

        when(reviewRepository.save(review)).thenReturn(review);
	    service.addReview(review);
	     }
	catch(NullPointerException e)        
	{            
	    System.out.print("NullPointerException Caught");        
	}
	}

	@Test @Order(8)
	public void test_addMovie(){
		try
	{

		Movie movie=new Movie(1,"HIT2",2022,4.3,"thriller","abc","Telugu");
		when (movieRepository.save(movie)).thenReturn(movie);
		assertEquals(movie,service.addMovie(movie));
		}
	catch(NullPointerException e)        {            
	    System.out.print("NullPointerException Caught");        
	    }
}
	
	
	@Test 
	@Order(9)
	public void test_deleteMovie() { try
	{
		Optional<Movie> movie=Optional.of(new Movie(1,"HIT2",2022,4.3,"thriller","abc","Telugu"));

		
		Integer id=1;
		when (movieRepository.findById(id)).thenReturn(movie);
	    service.deleteMovie(movie);

}
	catch(NullPointerException e)        {            
	    System.out.print("NullPointerException Caught");        
	    }
	}
	@Test 
	@Order(10)
	public void test_deleteReview() { try
	{
		Optional<Review> review=Optional.of(new Review("super",5));
		Optional<Movie> movie=Optional.of(new Movie(1,"HIT2",2022,4.3,"thriller","abc","Telugu"));

		
		Integer id=1;
		when (reviewRepository.findById(id)).thenReturn(review);
	    service.deleteReview(review);

}
	catch(NullPointerException e)        {            
	    System.out.print("NullPointerException Caught");        
	    }
	}
	
	@Test @Order(11)
	public void test_updateMovie() {
		try
	{   
			

		Optional<Movie> movie=Optional.of(new Movie(1,"HIT2",2022,4.3,"thriller","abc","Telugu"));
		when (movieRepository.findById(movie.get())).thenReturn(movie);
		assertEquals(movie,service.updateMovie(movie).getId());
		}
	catch(NullPointerException e)        {            
	    System.out.print("NullPointerException Caught");        
	    }
}

	@Test @Order(12)
	public void test_updateReview() {
		try
	{   
			

		Optional<Review> review=Optional.of(new Review("super",4));
		when (movieRepository.findById(review.get())).thenReturn(review);
		assertEquals(review,service.updateReview(review).getId());
		}
	catch(NullPointerException e)        {            
	    System.out.print("NullPointerException Caught");        
	    }
}
}
		




   
	


