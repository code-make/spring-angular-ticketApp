package com.example.canan;

import com.example.canan.model.Bus;
import com.example.canan.model.City;
import com.example.canan.model.Journey;
import com.example.canan.model.User;
import com.example.canan.repository.BusRepository;
import com.example.canan.repository.CityRepository;
import com.example.canan.repository.JourneyRepository;
import com.example.canan.repository.UserRepository;
import javafx.application.Application;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelmapper =new ModelMapper();
		modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelmapper;
	}
//	@Bean
//	public BCryptPasswordEncoder bCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	CommandLineRunner runner(JourneyRepository journeyRepository){
		return args -> {
			journeyRepository.save(new Journey("kocaeli","izmir",150,"2020-06-12","12:00","123","1234"));
			journeyRepository.save(new Journey("kocaeli","istanbul",140,"2020-06-16","12:00","124","1234"));
			journeyRepository.save(new Journey("kocaeli","ankara",130,"2020-06-20","12:00","125","1234"));
			journeyRepository.save(new Journey("kocaeli","izmir",110,"2020-06-25","12:00","126","1234"));
			journeyRepository.save(new Journey("kocaeli","izmir",110,"2020-06-25","16:00","127","1234"));
			journeyRepository.save(new Journey("kocaeli","izmir",110,"2020-06-25","18:00","128","1234"));
		};		}

/*	@Bean
	CommandLineRunner runners(UserRepository userRepository){
		return args -> {
			userRepository.save(new User("canans","1234","canan","serper","serpercanan@gmail.com","1234"));
		};
	}*/

	@Bean
	CommandLineRunner runnerB(BusRepository busRepository){
		return args -> {
			busRepository.save(new Bus("1234","SerperTurizm",1));
			busRepository.save(new Bus("1235","SerperTurizm",1));
			busRepository.save(new Bus("1236","SerperTurizm",1));
		};
	}

/*	@Bean
	CommandLineRunner runnerC(CityRepository cityRepository){
		return args -> {
			cityRepository.save(new City(1, "İZMİR"));
			cityRepository.save(new City(2, "KOCAELİ"));


		};
	}*/
}
