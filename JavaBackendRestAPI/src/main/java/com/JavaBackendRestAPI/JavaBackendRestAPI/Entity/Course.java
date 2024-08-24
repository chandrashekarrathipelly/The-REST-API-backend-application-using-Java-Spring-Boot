package com.JavaBackendRestAPI.JavaBackendRestAPI.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title_of_course;
    private String course_code;
    private String course_description;


    public Course() {
    }

    public Course(Long id, String title_of_course, String course_code, String course_description) {
        this.id = id;
        this.title_of_course = title_of_course;
        this.course_code = course_code;
        this.course_description = course_description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle_of_course() {
        return title_of_course;
    }

    public void setTitle_of_course(String title_of_course) {
        this.title_of_course = title_of_course;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title_of_course='" + title_of_course + '\'' +
                ", course_code='" + course_code + '\'' +
                ", course_description='" + course_description + '\'' +
                '}';
    }
}
