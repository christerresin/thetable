package com.example.thetable.appetizer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppetizerRepository extends JpaRepository<Appetizer, Long> {

  // @Query("SELECT a FROM Appetizer a WHERE a.mealTitle = ?1")
  Optional<Appetizer> findAppetizerByMealTitle(String mealTitle);

}
