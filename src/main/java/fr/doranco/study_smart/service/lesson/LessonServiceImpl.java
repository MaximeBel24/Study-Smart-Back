package fr.doranco.study_smart.service.lesson;

import fr.doranco.study_smart.entities.Lesson;
import fr.doranco.study_smart.entities.Module;
import fr.doranco.study_smart.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService{

    @Autowired
    LessonRepository lessonRepository;


    @Override
    public Lesson saveLesson(Lesson l) {
        return lessonRepository.save(l);
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
        lessonRepository.deleteById(id);
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
}
