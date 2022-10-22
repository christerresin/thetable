package com.example.thetable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class Meal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String mealTitle;
  private String imageUrl;
  private String videoUrl;
  private String mealDescription;
  private String ingredientsList;

  public Meal() {
  }

  public Meal(long id, String mealTitle, String imageUrl, String videoUrl, String mealDescription,
      String ingredientsList) {
    this.id = id;
    this.mealTitle = mealTitle;
    this.imageUrl = imageUrl;
    this.videoUrl = videoUrl;
    this.mealDescription = mealDescription;
    this.ingredientsList = ingredientsList;
  }

  public Meal(String mealTitle, String imageUrl, String videoUrl, String mealDescription,
      String ingredientsList) {
    this.mealTitle = mealTitle;
    this.imageUrl = imageUrl;
    this.videoUrl = videoUrl;
    this.mealDescription = mealDescription;
    this.ingredientsList = ingredientsList;

  }
}
