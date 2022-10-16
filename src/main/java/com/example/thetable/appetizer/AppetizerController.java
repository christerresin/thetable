package com.example.thetable.appetizer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/appetizer")
public class AppetizerController {
  private final AppetizerService appetizerService;

  @Autowired
  public AppetizerController(AppetizerService appetizerService) {
    this.appetizerService = appetizerService;
  }

  @GetMapping("/appetizers")
  public List<Appetizer> getAppetizers() {
    return appetizerService.getAppetizers();
  }

  @GetMapping
  public ResponseEntity<Appetizer> getAppetizer(@RequestParam(name = "appetizerId") long appetizerId) {
    Appetizer appetizer = appetizerService.getAppetizer(appetizerId);
    return new ResponseEntity<Appetizer>(appetizer, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Appetizer> registerNewAppetizer(@RequestBody Appetizer appetizer) {
    appetizerService.addNewAppetizer(appetizer);
    return new ResponseEntity<Appetizer>(appetizer, HttpStatus.CREATED);
  }

  @DeleteMapping
  public void deleteAppetizer(@RequestParam(name = "appetizerId") Long appetizerId) {
    appetizerService.deleteAppetizer(appetizerId);
  }

  @PutMapping
  public ResponseEntity<Appetizer> updateAppetizer(@RequestParam(name = "appetizerId") Long appetizerId,
      @RequestParam(name = "mealTitle", required = false) String mealTitle,
      @RequestParam(name = "imageUrl", required = false) String imageUrl,
      @RequestParam(name = "videoUrl", required = false) String videoUrl,
      @RequestParam(name = "mealDescription", required = false) String mealDescription,
      @RequestParam(name = "ingredientsList", required = false) String ingredientsList) {
    Appetizer appetizer = appetizerService.updateAppetizer(appetizerId, mealTitle, imageUrl, videoUrl, mealDescription,
        ingredientsList);
    return new ResponseEntity<Appetizer>(appetizer, HttpStatus.OK);
  }

}