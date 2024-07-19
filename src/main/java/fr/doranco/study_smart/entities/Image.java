package fr.doranco.study_smart.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;

    @Column(name = "image", length = 4048576)
    private byte[] image;

//    @ManyToOne
//    @JoinColumn(name = "course_id")
//    @JsonIgnore
//    private Course course;

    @OneToOne
    @JsonIgnore
    private Course course;
}
