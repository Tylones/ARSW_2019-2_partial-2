package edu.eci.arsw.airportfinder.airportfinder.airportfinderapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.airportfinder.airportfinder"})
public class AirportFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportFinderApplication.class, args);
	}
}
