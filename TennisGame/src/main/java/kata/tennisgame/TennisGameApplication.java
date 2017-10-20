package kata.tennisgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class TennisGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(TennisGameApplication.class, args);
	}
}
