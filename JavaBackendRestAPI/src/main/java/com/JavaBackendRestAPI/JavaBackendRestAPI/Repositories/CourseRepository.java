package com.JavaBackendRestAPI.JavaBackendRestAPI.Repositories;

import com.JavaBackendRestAPI.JavaBackendRestAPI.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
