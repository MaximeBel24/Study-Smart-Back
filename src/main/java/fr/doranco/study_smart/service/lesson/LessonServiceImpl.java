package fr.doranco.study_smart.service.lesson;

import fr.doranco.study_smart.entities.Lesson;
import fr.doranco.study_smart.entities.Module;
import fr.doranco.study_smart.repositories.LessonRepository;
import fr.doranco.study_smart.service.module.ModuleService;
import fr.doranco.study_smart.utils.DurationUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService{

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private DurationUtil durationUtil;

    @Override
    public Lesson saveLesson(Lesson l) {
        Lesson savedLesson = lessonRepository.save(l);
        updateModuleDuration(savedLesson.getModule().getId());
        return savedLesson;
    }

    @Override
    public Lesson updateLesson(Lesson l) {
        return lessonRepository.save(l);
    }

    @Override
    public void deleteLesson(Lesson l) {
        lessonRepository.delete(l);
    }

    @Override
    public void deleteLessonById(Long id) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lesson not found"));
        lessonRepository.delete(lesson);
        updateModuleDuration(lesson.getModule().getId());
    }

    @Override
    public Lesson getLesson(Long id) {
        return lessonRepository.findById(id).get();
    }

    @Override
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    @Override
    public List<Lesson> findByModule(Module module) {
        return lessonRepository.findByModule(module);
    }

    @Override
    public List<Lesson> findByModuleId(Long id) {
        return lessonRepository.findByModuleId(id);
    }

    private void updateModuleDuration(Long moduleId) {
        Module module = moduleService.getModule(moduleId);
        int totalDuration = module.getLessons().stream().mapToInt(Lesson::getDuration).sum();
        module.setDuration(totalDuration);
        moduleService.saveModule(module);
    }
}
