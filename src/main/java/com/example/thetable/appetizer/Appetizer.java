package com.example.thetable.appetizer;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.thetable.Meal;

@Entity
@Table(name = "appetizer")
public class Appetizer extends Meal {

  public Appetizer() {
  }

  public Appetizer(long id, String mealTitle, String imageUrl, String videoUrl, String mealDescription,
      String ingredientsList) {
    super(id, mealTitle, imageUrl, videoUrl, mealDescription, ingredientsList);
  }

  public Appetizer(String mealTitle, String imageUrl, String videoUrl, String mealDescription, String ingredientsList) {
    super(mealTitle, imageUrl, videoUrl, mealDescription, ingredientsList);
  }

}
