package com.example.thetable.appetizer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.thetable.Meal;

@Entity
@Table(name = "appetizer")
public class Appetizer extends Meal {

  public Appetizer() {
  }

  public Appetizer(long id, String mealTitle, String imageUrl, String videoUrl, String mealDescription) {
    super(id, mealTitle, imageUrl, videoUrl, mealDescription);
  }

  public Appetizer(String mealTitle, String imageUrl, String videoUrl, String mealDescription, String ingredientsList) {
    super(mealTitle, imageUrl, videoUrl, mealDescription, ingredientsList);
  }

}
