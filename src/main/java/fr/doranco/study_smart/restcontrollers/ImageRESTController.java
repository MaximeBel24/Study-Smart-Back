package fr.doranco.study_smart.restcontrollers;

import fr.doranco.study_smart.entities.Course;
import fr.doranco.study_smart.entities.Image;
import fr.doranco.study_smart.service.course.CourseService;
import fr.doranco.study_smart.service.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "*")
public class ImageRESTController {

    @Autowired
    ImageService imageService;

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        return imageService.uploadImage(file);
    }

    @RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
    public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
        return imageService.getImageDetails(id);
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
        return imageService.getImage(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteImage(@PathVariable("id") Long id){
        imageService.deleteImage(id);
    }

    @RequestMapping(value="/update", method = RequestMethod.PUT)
    public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
        return imageService.uploadImage(file);
    }

    @PostMapping(value = "/uploadImageCourse/{idCourse}")
    public Image uploadMultiImages(
            @RequestParam("image")MultipartFile file,
            @PathVariable("idCourse") Long idCourse
    ) throws IOException {
        return imageService.uploadImageCourse(file, idCourse);
    }

    @GetMapping(value = "/getImagesCourse/{idCourse}")
    public List<Image> getImagesCourse(@PathVariable("idCourse") Long idCourse) throws IOException {
        return imageService.getImagesByCourse(idCourse);
    }

    @PostMapping(value = "/uploadFS/{id}")
    public void uploadImageFS(
            @RequestParam("image") MultipartFile file,
            @PathVariable("id") Long id
    ) throws IOException {
        Course c = courseService.getCourse(id);
        c.setImagePath(id+".jpg");

        Files.write(Paths.get(System.getProperty("user.home") + "/images/" + c.getImagePath()), file.getBytes());
        courseService.saveCourse(c);
    }

    @GetMapping(value = "/loadfromFS/{id}", produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {
        Course c = courseService.getCourse(id);

        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/images/" + c.getImagePath()));
    }
}
