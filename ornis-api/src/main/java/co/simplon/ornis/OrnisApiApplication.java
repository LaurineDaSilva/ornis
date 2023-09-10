package co.simplon.ornis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class OrnisApiApplication {

    public static void main(String[] args) {
	SpringApplication.run(OrnisApiApplication.class,
		args);
    }

}
