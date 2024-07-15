package fr.doranco.study_smart.service.category;

import fr.doranco.study_smart.entities.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category c);
    Category updateCategory(Category c);
    void deleteCategory(Category c);
    void deleteCategoryById(Long id);
    Category getCategory(Long id);
    List<Category> getAllCategories();
}
