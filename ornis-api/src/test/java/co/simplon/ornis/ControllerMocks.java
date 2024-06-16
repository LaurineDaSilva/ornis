package co.simplon.ornis;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import co.simplon.ornis.controllers.BeakShapeController;
import co.simplon.ornis.controllers.BirdController;
import co.simplon.ornis.controllers.ColorController;
import co.simplon.ornis.controllers.FeetShapeController;
import co.simplon.ornis.controllers.SizeController;
import co.simplon.ornis.controllers.UserAccountController;

@TestConfiguration
public class ControllerMocks {

    @Bean
    BeakShapeController beakShapeController() {
	return Mockito.mock(BeakShapeController.class);
    }

    @Bean
    BirdController birdController() {
	return Mockito.mock(BirdController.class);
    }

    @Bean
    ColorController colorController() {
	return Mockito.mock(ColorController.class);
    }

    @Bean
    FeetShapeController feetShapeController() {
	return Mockito.mock(FeetShapeController.class);
    }

    @Bean
    SizeController sizeController() {
	return Mockito.mock(SizeController.class);
    }

    @Bean
    UserAccountController userAccountController() {
	return Mockito.mock(UserAccountController.class);
    }

}
