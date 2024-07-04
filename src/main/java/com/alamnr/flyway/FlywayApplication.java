package com.alamnr.flyway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alamnr.flyway.repository.BookRepository;

@SpringBootApplication
public class FlywayApplication implements CommandLineRunner {

	private final BookRepository bookRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(FlywayApplication.class, args);
	}

    public FlywayApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

	@Override
	public void run(String... args) throws Exception {
		bookRepository.findAll().forEach(book -> System.out.println(book.toString()));
	}

}
