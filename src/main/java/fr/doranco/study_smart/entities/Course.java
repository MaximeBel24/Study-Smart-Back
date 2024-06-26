package fr.doranco.study_smart.entities;

import jakarta.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String descritption;
    private String image;
    private double price;
    private int duration;
    private String level;

    @ManyToOne
    private Category category;

    public Course() {
    }

    public Course(String title, String descritption, String image, double price, int duration, String level) {
        this.title = title;
        this.descritption = descritption;
        this.image = image;
        this.price = price;
        this.duration = duration;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescritption() {
        return descritption;
    }

    public void setDescritption(String descritption) {
        this.descritption = descritption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", descritption='" + descritption + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                ", level='" + level + '\'' +
                '}';
    }
}
