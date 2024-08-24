package com.JavaBackendRestAPI.JavaBackendRestAPI.Service;

import com.JavaBackendRestAPI.JavaBackendRestAPI.Entity.CourseInstance;
import com.JavaBackendRestAPI.JavaBackendRestAPI.Repositories.CourseInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseInstanceService {
    @Autowired
    private CourseInstanceRepository courseInstanceRepository;
    public boolean saveCourseInstance(CourseInstance instance) {
            if(instance!= null){
                courseInstanceRepository.save(instance);
                return true;
            }
            return false;
    }
}
