package fr.doranco.study_smart.service;

import fr.doranco.study_smart.dto.CourseDTO;
import fr.doranco.study_smart.entities.Category;
import fr.doranco.study_smart.entities.Course;
import fr.doranco.study_smart.repositories.CourseRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CourseDTO saveCourse(CourseDTO c) {
        return convertEntityToDto(courseRepository.save(converDtoToEntity(c)));
    }

    @Override
    public CourseDTO updateCourse(CourseDTO c) {
        return convertEntityToDto(courseRepository.save(converDtoToEntity(c)));
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
    public CourseDTO getCourse(Long id) {
        return convertEntityToDto(courseRepository.findById(id).get());
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
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

    @Override
    public CourseDTO convertEntityToDto(Course course) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        CourseDTO courseDTO = modelMapper.map(course, CourseDTO.class);
        return courseDTO;
    }

    @Override
    public Course converDtoToEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course = modelMapper.map(courseDTO, Course.class);
        return course;
    }
}
