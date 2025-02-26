package hh.bookstore_new.bookstore_new;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.bookstore_new.bookstore_new.domain.Book;
import hh.bookstore_new.bookstore_new.domain.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hh.bookstore_new.bookstore_new.repository.BookRepository;
import hh.bookstore_new.bookstore_new.repository.CategoryRepository;

@SpringBootApplication
public class BookstoreNewApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreNewApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreNewApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			log.info("save a couple of books");
			Category horror = categoryRepository.save(new Category("Horror"));
			Category scifi = categoryRepository.save(new Category("Sci-Fi"));
			Category comedy = categoryRepository.save(new Category("Comedy"));

			bookRepository.save(new Book("Secrets of the forest", "King James", 1993, "4812-4581", 19.99, horror));
			bookRepository.save(new Book("Secrets of the forest", "King James", 1993, "4812-4581", 19.99, scifi));
			bookRepository.save(new Book("Secrets of the forest", "King James", 1993, "4812-4581", 19.99, comedy));
		};
	}

}
