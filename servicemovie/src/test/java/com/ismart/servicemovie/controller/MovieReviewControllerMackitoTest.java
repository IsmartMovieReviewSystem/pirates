package com.ismart.servicemovie.controller;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.ismart.servicemovie.entity.Movie;
import com.ismart.servicemovie.entity.Review;
import com.ismart.servicemovie.service.MovieReviewService;
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes= {MovieReviewControllerMackitoTest.class})
class MovieReviewControllerMackitoTest {
@Mock
MovieReviewService service;
@InjectMocks
MovieReviewController moviereviewcontroller;
List<Movie> mymovies;
Review review;
String review1;

Movie movie;
String movie1;


@Test
@Order(1)
public void test_getAllMovie()
{
	
	mymovies=new ArrayList<Movie>();
	mymovies.add(new Movie(1,"HIT2",2022,4.3,"thriller","abc","Telugu"));
	mymovies.add(new Movie(2,"HIT",2019,4.2,"thriller","abc","Telugu"));

	when(service.getAllMovies()).thenReturn(mymovies);
	moviereviewcontroller.getAllMovies();
}
@Test
@Order(2)
public  void test_getMovieById()
{
	movie=new Movie(1,"HIT2",2022,4.3,"thriller","abc","Telugu");
	int movieId=1;
	when(service.getMovieDetailsById(movieId)).thenReturn(movie);

	moviereviewcontroller.getMovieDetailsById(movieId);
}
@Test
@Order(3)
public void test_addMovie()
{
	movie=new Movie(3,"RRR",2022,4.8,"Action","Rajamouli","Telugu");


	when(service.addMovie(movie)).thenReturn(movie);
	moviereviewcontroller.addMovie(movie);
}

@Test
@Order(4)
public  void test_removeMovie()
{
	movie=new Movie(3,"RRR",2022,4.8,"Action","Rajamouli","Telugu");
	int movieId=3;
     when(service.deleteMovie(movieId)).thenReturn(movie1);

	moviereviewcontroller.deleteMovie(movieId);
}
@Test
@Order(5)
public void test_getMovieReviewById()
{
	review=new Review("super",5);
	movie=new Movie(3,"RRR",2022,4.8,"Action","Rajamouli","Telugu");
	int Id=3;
	when(service.getReviewById(Id)).thenReturn((Review) review);
	moviereviewcontroller.getReviewById(Id);
}
@Test
@Order(6)
public  void test_deleteReview()
{
	movie=new Movie(3,"RRR",2022,4.8,"Action","Rajamouli","Telugu");
	review=new Review("super",5);

	int Id=3;
	when(service.deleteReview(Id)).thenReturn(review1);
    moviereviewcontroller.deleteReview(Id);
}
@Test
@Order(7)
public void test_updateMovieReview()
{
	movie=new Movie(3,"RRR",2022,4.8,"Action","Rajamouli","Telugu");
	review=new Review("super",4);

	when(service.updateReview(review)).thenReturn(review);
    moviereviewcontroller.updateReview(review);
}
}



