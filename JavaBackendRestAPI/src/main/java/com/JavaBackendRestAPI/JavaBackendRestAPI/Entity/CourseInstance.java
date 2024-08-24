package com.JavaBackendRestAPI.JavaBackendRestAPI.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CourseInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String year_of_delivery;
    private String semester_of_delivery;
    private String course_id;

    public CourseInstance() {
    }

    public CourseInstance(Long id, String year_of_delivery, String semester_of_delivery, String course_id) {
        this.id = id;
        this.year_of_delivery = year_of_delivery;
        this.semester_of_delivery = semester_of_delivery;
        this.course_id = course_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYear_of_delivery() {
        return year_of_delivery;
    }

    public void setYear_of_delivery(String year_of_delivery) {
        this.year_of_delivery = year_of_delivery;
    }

    public String getSemester_of_delivery() {
        return semester_of_delivery;
    }

    public void setSemester_of_delivery(String semester_of_delivery) {
        this.semester_of_delivery = semester_of_delivery;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "CourseInstance{" +
                "id=" + id +
                ", year_of_delivery='" + year_of_delivery + '\'' +
                ", semester_of_delivery='" + semester_of_delivery + '\'' +
                ", course_id='" + course_id + '\'' +
                '}';
    }
}
