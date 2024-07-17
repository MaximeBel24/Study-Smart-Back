package fr.doranco.study_smart.restcontrollers;

import fr.doranco.study_smart.entities.Lesson;
import fr.doranco.study_smart.service.lesson.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
@CrossOrigin(origins = "*")
public class LessonRESTController {

    @Autowired
    LessonService lessonService;

    @GetMapping(path = "all")
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @GetMapping(value = "/getbyid/{id}")
    public Lesson getLessonById(@PathVariable("id") Long id) {
        return lessonService.getLesson(id);
    }

    @PostMapping(value = "/add")
    public Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonService.saveLesson(lesson);
    }

    @PutMapping(value = "/update")
    public Lesson updateLesson(@RequestBody Lesson lesson) {
        return lessonService.updateLesson(lesson);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteLessonById(@PathVariable("id") Long id) {
        lessonService.deleteLessonById(id);
    }

    @GetMapping(value = "/getbymoduleid/{id}")
    public List<Lesson> getLessonByModuleId(@PathVariable("id") Long id) {
        return lessonService.findByModuleId(id);
    }


}
