package hh.bookstore_new.bookstore_new.repository;

import org.springframework.data.repository.CrudRepository;
import hh.bookstore_new.bookstore_new.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
