package com.fonsdev.library;

import com.fonsdev.library.User.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@RestController
public class LibraryApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}
	@RequestMapping("/")
	public List<String> welcome() {
		return List.of("Welcome to the other side, coder :)");
	}
}
