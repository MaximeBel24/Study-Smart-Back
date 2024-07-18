package fr.doranco.study_smart.repositories;

import fr.doranco.study_smart.entities.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class LessonRepositoryTest {

    @Autowired
    private LessonRepository lessonRepository;

    public void testFindByIdAndModuleIdAndCourseId() {
        Long courseId = 1L;
        Long moduleId = 1L;
        Long lessonId = 1L;

        Lesson lesson = lessonRepository.findByIdAndModuleIdAndCourseId(lessonId, moduleId, courseId);

        assertThat(lesson).isNotNull();
        assertThat(lesson.getId()).isEqualTo(lessonId);
        assertThat(lesson.getModule().getId()).isEqualTo(moduleId);
        assertThat(lesson.getModule().getCourse().getId()).isEqualTo(courseId);
    }
}
