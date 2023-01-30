package com.ismart.servicemovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ismart.servicemovie.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{

}
