package hh.bookstore_new.bookstore_new.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import hh.bookstore_new.bookstore_new.domain.Book;
import hh.bookstore_new.bookstore_new.repository.BookRepository;

@CrossOrigin
@Controller
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;


    //shows all the books in json format with /api/books
    @GetMapping("/books")
    public @ResponseBody List<Book> booklistRest() {
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> bookByIdRest(@PathVariable Long id) {
        return bookRepository.findById(id);
    }


    @PostMapping("/books")
    public @ResponseBody Book saveStudentRest(@RequestBody Book book) {
        return bookRepository.save(book);
    }
}
