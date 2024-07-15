package fr.doranco.study_smart.service.category;

import fr.doranco.study_smart.entities.Category;
import fr.doranco.study_smart.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category c) {
        return categoryRepository.save(c);
    }

    @Override
    public Category updateCategory(Category c) {
        return categoryRepository.save(c);
    }

    @Override
    public void deleteCategory(Category c) {
        categoryRepository.delete(c);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
