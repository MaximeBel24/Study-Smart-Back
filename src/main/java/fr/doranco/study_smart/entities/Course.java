package fr.doranco.study_smart.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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
    private String title;
    private String description;
    private double price;
    private int duration;
    private String level;

    @ManyToOne
    private Category category;

    @OneToMany (mappedBy = "course")
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