package hh.bookstore_new.bookstore_new.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    
     //http://localhost:8080/index
    @GetMapping("/index")
    public String index() {
        
        return "";
    }
}
