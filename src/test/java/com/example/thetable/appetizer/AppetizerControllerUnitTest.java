package com.example.thetable.appetizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AppetizerControllerUnitTest {

  @Test
  void shouldReturnAppetizer() {
    AppetizerService appetizerService = Mockito.mock(AppetizerService.class);
    when(appetizerService.getAppetizer(1)).thenReturn(
        new Appetizer("Salmon Surprise", "none", "none", "amazing salmon on a golden plate", "salmon, shellfish"));
    AppetizerController appetizerController = new AppetizerController(appetizerService);
    assertEquals(200, appetizerController.getAppetizer(1).getStatusCodeValue());
    assertEquals("Salmon Surprise", appetizerController.getAppetizer(1).getBody().getMealTitle());
    assertEquals(
        new Appetizer("Salmon Surprise", "none", "none", "amazing salmon on a golden plate", "salmon, shellfish"),
        appetizerController.getAppetizer(1).getBody());
  }

  @Test
  void shouldReturnAppetizersList() {

  }

}
