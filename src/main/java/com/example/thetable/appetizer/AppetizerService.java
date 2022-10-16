package com.example.thetable.appetizer;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppetizerService {

  private final AppetizerRepository appetizerRepository;

  @Autowired
  public AppetizerService(AppetizerRepository appetizerRepository) {
    this.appetizerRepository = appetizerRepository;
  }

  public List<Appetizer> getAppetizers() {
    return appetizerRepository.findAll();
  }

  public Appetizer addNewAppetizer(Appetizer appetizer) {
    Optional<Appetizer> appetizerOptional = appetizerRepository.findAppetizerByMealTitle(appetizer.getMealTitle());
    if (appetizerOptional.isPresent()) {
      throw new IllegalStateException("A appetizer with that name already exist");
    }
    return appetizerRepository.save(appetizer);
  }

  public void deleteAppetizer(long appetizerId) {
    boolean exists = appetizerRepository.existsById(appetizerId);
    if (!exists) {
      throw new IllegalStateException("Appetizer with id " + appetizerId + " does not exist. Unable to delete");
    }
    appetizerRepository.deleteById(appetizerId);
  }

  @Transactional
  public Appetizer updateAppetizer(long appetizerId, String mealTitle, String imageUrl, String videoUrl,
      String mealDescription, String ingredientsList) {
    Appetizer appetizer = appetizerRepository.findById(appetizerId)
        .orElseThrow(() -> new IllegalStateException("Appetizer with id " + appetizerId + " does not exist"));

    if (mealTitle != null && mealTitle.length() > 0 && !Objects.equals(appetizer.getMealTitle(), mealTitle)) {
      appetizer.setMealTitle(mealTitle);
    }

    if (imageUrl != null && imageUrl.length() > 0 && !Objects.equals(appetizer.getImageUrl(), imageUrl)) {
      appetizer.setImageUrl(imageUrl);
    }

    if (videoUrl != null && videoUrl.length() > 0 && !Objects.equals(appetizer.getVideoUrl(), videoUrl)) {
      appetizer.setVideoUrl(videoUrl);
    }

    if (mealDescription != null && mealDescription.length() > 0
        && !Objects.equals(appetizer.getMealDescription(), mealDescription)) {
      appetizer.setMealDescription(mealDescription);
    }
    return appetizer;
  }

  public Appetizer getAppetizer(long appetizerId) {
    // TODO - define custom exception to return a 404 back to the user instead of
    // LAMBDA
    return appetizerRepository.findById(appetizerId).orElseThrow(() -> new RuntimeException("not found"));
  }

}
