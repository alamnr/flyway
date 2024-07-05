package com.alamnr.flyway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alamnr.flyway.repository.BookRepository;
import com.alamnr.flyway.repository.OrderRepository;

@SpringBootApplication
public class FlywayApplication implements CommandLineRunner {

	private final BookRepository bookRepository;
	private final OrderRepository orderRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(FlywayApplication.class, args);
	}

    public FlywayApplication(BookRepository bookRepository, OrderRepository orderRepository) {
        this.bookRepository = bookRepository;
		this.orderRepository = orderRepository;
    }

	@Override
	public void run(String... args) throws Exception {
		bookRepository.findAll().forEach(book -> System.out.println(book.toString()));
		orderRepository.findAllContainingMacBookPro().forEach(order -> System.out.println(order.toString()));
	}

}
