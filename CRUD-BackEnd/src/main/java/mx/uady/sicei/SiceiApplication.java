package mx.uady.sicei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

// Anotaciones - Decorators
// metodos, clases o atributos
@SpringBootApplication
@EnableAsync
public class SiceiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiceiApplication.class, args);
	}

}
