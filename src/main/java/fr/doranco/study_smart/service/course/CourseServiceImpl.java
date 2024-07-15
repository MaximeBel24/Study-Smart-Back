package fr.doranco.study_smart.service.course;

import fr.doranco.study_smart.entities.Category;
import fr.doranco.study_smart.entities.Course;
import fr.doranco.study_smart.repositories.CourseRepository;
import fr.doranco.study_smart.repositories.ImageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Course saveCourse(Course c) {
        return courseRepository.save(c);
    }

    @Override
    public Course updateCourse(Course c) {
//        Long oldCourseImageId = this.getCourse(c.getId()).getImage().getIdImage();
//        Long newCourseImageId = c.getImage().getIdImage();

            Course courseUpdated = courseRepository.save(c);

//            if (oldCourseImageId != newCourseImageId)
//                imageRepository.deleteById(oldCourseImageId);

        return courseUpdated;
    }

    @Override
    public void deleteCourse(Course c) {
        courseRepository.delete(c);
    }

    @Override
    public void deleteCourseById(Long id) {
        Course c = getCourse(id);
        // supprimer l'image avant de supprimer le cours
        try {
            Files.delete(Paths.get(System.getProperty("user.home")+"/images/" + c.getImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        courseRepository.deleteById(id);
    }

    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public List<Course> getAllCourses() {
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
