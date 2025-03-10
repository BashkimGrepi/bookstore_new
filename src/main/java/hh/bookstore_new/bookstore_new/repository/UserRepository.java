package hh.bookstore_new.bookstore_new.repository;

import org.springframework.data.repository.CrudRepository;

import hh.bookstore_new.bookstore_new.domain.User;
import java.util.List;


public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);
}
