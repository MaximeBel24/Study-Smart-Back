package fr.doranco.study_smart.restcontrollers;

import fr.doranco.study_smart.dto.CourseDTO;
import fr.doranco.study_smart.entities.Course;
import fr.doranco.study_smart.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CourseRESTController {

    @Autowired
    CourseService courseService;

    @RequestMapping(method = RequestMethod.GET)
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public CourseDTO getCourseById(@PathVariable("id") Long id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.saveCourse(courseDTO);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public CourseDTO updateCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.updateCourse(courseDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduit(@PathVariable("id") Long id) {
        courseService.deleteCourseById(id);
    }

    @RequestMapping(value = "/coursescat/{id}", method = RequestMethod.GET)
    public List<Course> getCourseByCategoryId(@PathVariable("id") Long id) {
        return courseService.findByCategoryId(id);
    }

    @RequestMapping(value="/courseByTitle/{title}", method = RequestMethod.GET)
    public List<Course> findByTitleContains(@PathVariable("title") String title) {
        return courseService.findByTitleContains(title);
    }
}
