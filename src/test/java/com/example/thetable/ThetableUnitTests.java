package com.example.thetable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.thetable.health.HealthController;

@SpringBootTest
class ThetableUnitTests {

	@Test
	void should200() {
		HealthController healthController = new HealthController();
		assertEquals(healthController.ebHealth().getStatusCodeValue(), 200);
	}

	@Test
	void healthShould200() {
		HealthController healthController = new HealthController();
		assertEquals(healthController.health().getStatusCodeValue(), 200);
	}

}
