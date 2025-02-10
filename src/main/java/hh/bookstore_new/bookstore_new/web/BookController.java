package hh.bookstore_new.bookstore_new.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.bookstore_new.bookstore_new.domain.Book;
import hh.bookstore_new.bookstore_new.domain.BookRepository;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    List<Book> books = new ArrayList<Book>();

    // http://localhost:8080/booklist
    @GetMapping("/booklist")
    public String showAllBooks(Model model) {
        books = (List<Book>) bookRepository.findAll();
        model.addAttribute("books", books);
        return "booklist";
    }
}
