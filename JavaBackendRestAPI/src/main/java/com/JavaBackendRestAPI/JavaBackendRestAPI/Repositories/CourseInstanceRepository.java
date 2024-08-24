package com.JavaBackendRestAPI.JavaBackendRestAPI.Repositories;

import com.JavaBackendRestAPI.JavaBackendRestAPI.Entity.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {

    List<CourseInstance> findByYearAndSemester(String year, String semester);
}
