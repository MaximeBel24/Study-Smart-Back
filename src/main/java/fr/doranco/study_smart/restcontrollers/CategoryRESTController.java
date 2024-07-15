package fr.doranco.study_smart.restcontrollers;

import fr.doranco.study_smart.entities.Category;
import fr.doranco.study_smart.repositories.CategoryRepository;
import fr.doranco.study_smart.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*")
public class CategoryRESTController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(path = "all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping(value = "/getbyid/{id}")
    public Category getCategoryById(@PathVariable("id") Long id) {
        return categoryService.getCategory(id);
    }

    @PostMapping(value = "/add")
    public Category createCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @PutMapping(value = "/update")
    public Category updateCategory(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteCategoryById(@PathVariable("id") Long id) {
        categoryService.deleteCategoryById(id);
    }

}
