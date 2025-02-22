package hh.bookstore_new.bookstore_new.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.bookstore_new.bookstore_new.domain.Category;
import hh.bookstore_new.bookstore_new.repository.CategoryRepository;

@Controller
public class CategoryController {
    

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    @GetMapping("/categorylist")
    public String showCategoryList(Model model) {
        model.addAttribute("category", categoryRepository.findAll());
        return "categorylist";
    }
    @GetMapping("/addcategory")
    public String addCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }
    @PostMapping("/addcategory")
    public String addCategory(Category category) {
        categoryRepository.save(category);
        return "redirect:/categorylist";
    }    
    
}
