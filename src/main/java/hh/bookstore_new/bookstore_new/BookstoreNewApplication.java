package hh.bookstore_new.bookstore_new;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.bookstore_new.bookstore_new.domain.Book;
import hh.bookstore_new.bookstore_new.domain.Category;

import hh.bookstore_new.bookstore_new.repository.BookRepository;
import hh.bookstore_new.bookstore_new.repository.CategoryRepository;

@SpringBootApplication
public class BookstoreNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreNewApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			bookRepository.save(new Book("Odyssean ihmeet", "James Dean", 1996, "6453-3481", 49.99));
			bookRepository.save(new Book("Harry potter", "J.K.Rowling", 1996, "6453-1447", 49.99));
			bookRepository.save(new Book("Odyssean ihmeet", "James Dean", 1996, "6453-321144", 49.99));

			categoryRepository.save(new Category("Sci_fi"));
			categoryRepository.save(new Category("Comedy"));
			categoryRepository.save(new Category("Fantasy"));
			categoryRepository.save(new Category("Horror"));
		};

	}

}
