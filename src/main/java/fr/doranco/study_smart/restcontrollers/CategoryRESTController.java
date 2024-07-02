package fr.doranco.study_smart.restcontrollers;

import fr.doranco.study_smart.entities.Category;
import fr.doranco.study_smart.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin("*")
public class CategoryRESTController {

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable("id") Long id) {
        return categoryRepository.findById(id).get();
    }
}
