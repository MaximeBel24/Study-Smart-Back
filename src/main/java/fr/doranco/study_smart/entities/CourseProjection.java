package fr.doranco.study_smart.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "title", types = {Course.class})
public interface CourseProjection {
    public String getTitle();
}
