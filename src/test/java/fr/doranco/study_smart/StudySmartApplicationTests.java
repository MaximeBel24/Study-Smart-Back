package fr.doranco.study_smart;

import fr.doranco.study_smart.entities.Course;
import fr.doranco.study_smart.repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudySmartApplicationTests {

	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void testCreateCourse() {
		Course course = new Course("Cours Java", "test", "test image", 19.99, 20, "Débutant");
	}

	@Test
	public void testFindCourse() {
		Course c = courseRepository.findById(1L).get();
		System.out.println(c);
	}

	@Test
	public void testUpdateCourse() {
		Course c = courseRepository.findById(1L).get();
		c.setPrice(14.99);
		courseRepository.save(c);
	}

	@Test
	public void testListAllCourses()
	{
		List<Course> courses = courseRepository.findAll();
		for (Course c : courses)
		{
			System.out.println(c);
		}
	}

	@Test
	public void testDeleteCourse() {
		courseRepository.deleteById(1L);
	}

}
