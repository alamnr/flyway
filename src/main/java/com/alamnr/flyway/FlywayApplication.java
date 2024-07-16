package com.alamnr.flyway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alamnr.flyway.httpClient.ApacheHttpClient;
import com.alamnr.flyway.httpClient.JavaHttpClient;
import com.alamnr.flyway.httpClient.OkHttpClientExample;
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
		JavaHttpClient javaHttpClient = new JavaHttpClient("https://quotes.rest");
		System.out.println(" Get random quote by java http client  : " + javaHttpClient.getRandomQuote());

		OkHttpClientExample okHttpClient = new OkHttpClientExample("https://quotes.rest");
		System.out.println("Random quote by okhttp client: " + okHttpClient.getRandomQuote());

		ApacheHttpClient apacheHttpClient = new ApacheHttpClient("https://quotes.rest");
		System.out.println(" Get random quote by apache http client  : " + apacheHttpClient.getRandomQuote());

	}

}
