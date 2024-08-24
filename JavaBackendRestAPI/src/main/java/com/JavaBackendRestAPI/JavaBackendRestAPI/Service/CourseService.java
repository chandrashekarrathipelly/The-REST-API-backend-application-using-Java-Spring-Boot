package com.JavaBackendRestAPI.JavaBackendRestAPI.Service;

import com.JavaBackendRestAPI.JavaBackendRestAPI.Entity.Course;
import com.JavaBackendRestAPI.JavaBackendRestAPI.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public boolean saveCourse(Course course) {
        if(course!=null){
            courseRepository.save(course);
            return true;
        }
        return false;
    }
}
