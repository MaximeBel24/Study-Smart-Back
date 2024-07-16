package fr.doranco.study_smart.restcontrollers;

import fr.doranco.study_smart.entities.Course;
import fr.doranco.study_smart.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseRESTController {

    @Autowired
    CourseService courseService;

    @GetMapping(path = "all")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping(value="/getbyid/{id}")
    public Course getCourseById(@PathVariable("id") Long id) {
        return courseService.getCourse(id);
    }

    @PostMapping(value="/add")
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @PutMapping(value="/update")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    @DeleteMapping(value="/delete/{id}")
    public void deleteProduit(@PathVariable("id") Long id) {
        courseService.deleteCourseById(id);
    }

    @GetMapping(value = "/getbycategory/{id}")
    public List<Course> getCourseByCategoryId(@PathVariable("id") Long id) {
        return courseService.findByCategoryId(id);
    }

    @GetMapping(value="/getbytitle/{title}")
    public List<Course> findByTitleContains(@PathVariable("title") String title) {
        return courseService.findByTitleContains(title);
    }

    @PutMapping("/update-duration/{courseId}")
    public ResponseEntity<Course> updateCourseDuration(@PathVariable Long courseId) {
        Course updatedCourse = courseService.updateCourseDuration(courseId);
        return ResponseEntity.ok(updatedCourse);
    }
}
