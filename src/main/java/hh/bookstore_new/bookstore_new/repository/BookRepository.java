package hh.bookstore_new.bookstore_new.repository;

import org.springframework.data.repository.CrudRepository;

import hh.bookstore_new.bookstore_new.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
