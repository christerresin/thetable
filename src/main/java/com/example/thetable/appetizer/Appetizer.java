package com.example.thetable.appetizer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "appetizer")
@Data
public class Appetizer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String mealTitle;
  private String imageUrl;
  private String videoUrl;
  private String mealDescription;
  private String ingredientsList;

  public Appetizer() {
  }

  public Appetizer(long id, String mealTitle, String imageUrl, String videoUrl, String mealDescription) {
    this.id = id;
    this.mealTitle = mealTitle;
    this.imageUrl = imageUrl;
    this.videoUrl = videoUrl;
    this.mealDescription = mealDescription;
  }

  public Appetizer(String mealTitle, String imageUrl, String videoUrl, String mealDescription,
      String ingredientsList) {
    this.mealTitle = mealTitle;
    this.imageUrl = imageUrl;
    this.videoUrl = videoUrl;
    this.mealDescription = mealDescription;
    this.ingredientsList = ingredientsList;

  }

}
