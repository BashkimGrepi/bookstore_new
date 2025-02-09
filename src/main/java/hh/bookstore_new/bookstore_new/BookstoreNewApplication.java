package hh.bookstore_new.bookstore_new;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.bookstore_new.bookstore_new.domain.Book;
import hh.bookstore_new.bookstore_new.domain.BookRepository;

@SpringBootApplication
public class BookstoreNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreNewApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {
			bookRepository.save(new Book("Odyssean ihmeet", "James Dean", 1996, 6453, 49.99));
			bookRepository.save(new Book("Harry potter", "J.K.Rowling", 1996, 6453, 49.99));
			bookRepository.save(new Book("Odyssean ihmeet", "James Dean", 1996, 6453, 49.99));
		
		};
	}

}
