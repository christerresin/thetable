package com.example.thetable.appetizer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

  @GetMapping
  public List<Appetizer> getAppetizers() {
    return appetizerService.getAppetizers();
  }

  @PostMapping
  public void registerNewAppetizer(@RequestBody Appetizer appetizer) {
    appetizerService.addNewAppetizer(appetizer);
  }

  @DeleteMapping(path = "{appetizerId}")
  public void deleteAppetizer(@PathVariable("appetizerId") Long appetizerId) {
    appetizerService.deleteAppetizer(appetizerId);
  }

  @PutMapping(path = "{appetizerId}")
  public void updateAppetizer(@PathVariable("appetizerId") Long appetizerId,
      @RequestParam(required = false) String mealTitle, @RequestParam(required = false) String imageUrl,
      @RequestParam(required = false) String videoUrl, @RequestParam(required = false) String mealDescription,
      @RequestParam(required = false) String ingredientsList) {
    appetizerService.updateAppetizer(appetizerId, mealTitle, imageUrl, videoUrl, mealDescription, ingredientsList);
  }

}
