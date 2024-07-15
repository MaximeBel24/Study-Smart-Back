package fr.doranco.study_smart.service.image;

import fr.doranco.study_smart.entities.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    Image uploadImage(MultipartFile file) throws IOException;
    Image getImageDetails(Long id) throws IOException;
    ResponseEntity<byte[]> getImage(Long id) throws IOException;
    void deleteImage(Long id);

    Image uploadImageCourse(MultipartFile file, Long idCourse) throws IOException;
    List<Image> getImagesByCourse(Long idCourse);
}
