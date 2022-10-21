package com.example.thetable.appetizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AppetizerControllerUnitTest {
  Appetizer firstAppetizer = new Appetizer("Salmon Surprise", "none", "none", "amazing salmon on a golden plate",
      "salmon, shellfish");

  Appetizer secondAppetizer = new Appetizer("Salmon Surprise", "none", "none", "amazing salmon on a golden plate",
      "salmon, shellfish");

  List<Appetizer> actual = Arrays.asList(firstAppetizer, secondAppetizer);
  List<Appetizer> expected = Arrays.asList(firstAppetizer, secondAppetizer);

  @Test
  void shouldReturnAppetizer() {
    AppetizerService appetizerService = Mockito.mock(AppetizerService.class);
    when(appetizerService.getAppetizer(1)).thenReturn(firstAppetizer);
    AppetizerController appetizerController = new AppetizerController(appetizerService);
    assertEquals(200, appetizerController.getAppetizer(1).getStatusCodeValue());
    assertEquals("Salmon Surprise", appetizerController.getAppetizer(1).getBody().getMealTitle());
    assertEquals(
        firstAppetizer,
        appetizerController.getAppetizer(1).getBody());
  }

  @Test
  void shouldReturnAppetizersList() {
    AppetizerService appetizerService = Mockito.mock(AppetizerService.class);
    when(appetizerService.getAllAppetizers()).thenReturn(actual);
    AppetizerController appetizerController = new AppetizerController(appetizerService);
    assertEquals(expected, appetizerController.getAllAppetizers());
  }

}
