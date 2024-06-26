package fr.doranco.study_smart.service;

import fr.doranco.study_smart.entities.Category;
import fr.doranco.study_smart.entities.Course;
import fr.doranco.study_smart.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course saveCourse(Course c) {
        return courseRepository.save(c);
    }

    @Override
    public Course updateCourse(Course c) {
        return courseRepository.save(c);
    }

    @Override
    public void deleteCourse(Course c) {
        courseRepository.delete(c);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> findByTitle(String title) {
        return courseRepository.findByTitle(title);
    }

    @Override
    public List<Course> findByTitleContains(String title) {
        return courseRepository.findByTitleContains(title);
    }

    @Override
    public List<Course> findByNamePrice(String title, Double price) {
        return courseRepository.findByTitlePrice(title, price);
    }

    @Override
    public List<Course> findByCategory(Category category) {
        return courseRepository.findByCategory(category);
    }

    @Override
    public List<Course> findByCategoryId(Long id) {
        return courseRepository.findByCategoryId(id);
    }

    @Override
    public List<Course> findByOrderByTitleAsc() {
        return courseRepository.findByOrderByTitleAsc();
    }

    @Override
    public List<Course> sortTitlePrice() {
        return courseRepository.sortTitlePrice();
    }
}
