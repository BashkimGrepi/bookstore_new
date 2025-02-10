package hh.bookstore_new.bookstore_new.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/addbook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

      @PostMapping("/addbook")
      public String addBook(@ModelAttribute Book book) {
          bookRepository.save(book);
          return "redirect:/booklist";
      }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }
}
