package fr.doranco.study_smart.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String content;
    private int duration;

    @ManyToOne
    @JoinColumn(name = "module_id")
    @JsonBackReference
    private Module module;
}
