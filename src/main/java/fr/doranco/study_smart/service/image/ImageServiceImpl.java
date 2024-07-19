package fr.doranco.study_smart.service.image;

import fr.doranco.study_smart.entities.Course;
import fr.doranco.study_smart.entities.Image;
import fr.doranco.study_smart.repositories.CourseRepository;
import fr.doranco.study_smart.repositories.ImageRepository;
import fr.doranco.study_smart.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseService courseService;


    @Override
    public Image uploadImage(MultipartFile file) throws IOException {
        return imageRepository.save(Image.builder()
            .name(file.getOriginalFilename())
            .type(file.getContentType())
            .image(file.getBytes()).build());
    }

    @Override
    public Image getImageDetails(Long id) throws IOException {
        final Optional<Image> dbImage = imageRepository.findById(id);

        return Image.builder()
                .id(dbImage.get().getId())
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(dbImage.get().getImage()).build();
    }

    @Override
    public ResponseEntity<byte[]> getImage(Long id) throws IOException {
        final Optional<Image> dbImage = imageRepository.findById(id);


        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(dbImage.get().getImage());
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public Image uploadImageCourse(MultipartFile file, Long idCourse) throws IOException {
        Course c = new Course();
        c.setId(idCourse);
        return imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(file.getBytes())
                .course(c).build());
    }

    @Override
    public List<Image> getImagesByCourse(Long idCourse) {
        Course c = courseRepository.findById(idCourse).get();
//        return c.getImages();
        return null;
    }
}
