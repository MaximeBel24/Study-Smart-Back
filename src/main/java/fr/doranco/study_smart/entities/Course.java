package fr.doranco.study_smart.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 255, message = "Title must be less than 255 characters")
    private String title;

    @NotBlank(message = "Description is mandatory")
    @Size(max = 5000, message = "Description must be less than 5000 characters")
    private String description;

    @PositiveOrZero(message = "Price must be zero or positive or zero")
    private double price;

    @PositiveOrZero(message = "Duration must be positive")
    private int duration;

    @NotBlank(message = "Level is mandatory")
    @Pattern(regexp = "Débutant|Intermédiaire|Expert", message = "Level must be one of the following: Beginner, Intermediate, Advanced")
    private String level;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "course")
    private List<Image> images;

    private String imagePath;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Module> modules;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", images='" + images + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                ", level='" + level + '\'' +
                '}';
    }

}
