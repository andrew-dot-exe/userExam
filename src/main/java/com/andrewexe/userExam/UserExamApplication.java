package com.andrewexe.userExam;

import com.andrewexe.userExam.models.Country;
import com.andrewexe.userExam.models.User;
import com.andrewexe.userExam.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class UserExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserExamApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository) {
		return args -> {
			userRepository.deleteAll();
			List<User> testUsers = Arrays.asList(
					new User(null, "Иван", 25, Country.RUSSIA),
					new User(null, "Мария", 30, Country.RUSSIA),
					new User(null, "John", 28, Country.BRASIL),
					new User(null, "Priya", 22, Country.INDIA),
					new User(null, "Wei", 35, Country.CHINA),
					new User(null, "Sipho", 27, Country.SOUTH_AFRICA),
					new User(null, "Ольга", 29, Country.RUSSIA),
					new User(null, "Carlos", 31, Country.BRASIL),
					new User(null, "Ananya", 24, Country.INDIA),
					new User(null, "Li", 40, Country.CHINA)
			);
			userRepository.saveAll(testUsers);
		};
	}
}
