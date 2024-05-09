package br.com.fiap.moviebox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MovieboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieboxApplication.class, args);
	}

}
