package com.example.monsters;

import com.example.monsters.monster.Monster;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class MonstersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonstersApplication.class, args);
	}

	@GetMapping
	public List<Monster> hello() {
		return List.of(
				new Monster(
						"Bears",
						"A bear",
						"URL",
						"Skellige",
						"None",
						"None",
						LocalDate.now(),
						1
				)
		);
	}
}
