package hh.bookstore_new.bookstore_new.repository;

import org.springframework.data.repository.CrudRepository;

import hh.bookstore_new.bookstore_new.domain.Book;
import java.util.List;


public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
    
}
