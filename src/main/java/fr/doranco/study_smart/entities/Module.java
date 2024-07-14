package fr.doranco.study_smart.entities;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int duration;

    @ManyToOne
    private Course course;

}
