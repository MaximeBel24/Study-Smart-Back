package fr.doranco.study_smart.restcontrollers;

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
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Course getCourseById(@PathVariable("id") Long id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduit(@PathVariable("id") Long id) {
        courseService.deleteCourseById(id);
    }

    @RequestMapping(value = "/coursescat/{id}", method = RequestMethod.GET)
    public List<Course> getCourseByCategoryId(@PathVariable("id") Long id) {
        return courseService.findByCategoryId(id);
    }
}
