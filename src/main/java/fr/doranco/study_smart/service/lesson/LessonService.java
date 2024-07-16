package fr.doranco.study_smart.service.lesson;

import fr.doranco.study_smart.entities.Lesson;
import fr.doranco.study_smart.entities.Module;

import java.util.List;

public interface LessonService {
    Lesson saveLesson(Lesson l);
    Lesson updateLesson(Lesson l);
    void deleteLesson(Lesson l);
    void deleteLessonById(Long id);
    Lesson getLesson(Long id);
    List<Lesson> getAllLessons();
    List<Lesson> findByModule(Module module);
    List<Lesson> findByModuleId(Long id);
}
