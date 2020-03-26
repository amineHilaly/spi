package main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("main")
public class SpiiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpiiApplication.class, args);
	}
	

}
