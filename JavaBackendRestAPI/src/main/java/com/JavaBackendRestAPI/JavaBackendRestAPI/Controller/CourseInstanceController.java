package com.JavaBackendRestAPI.JavaBackendRestAPI.Controller;

import com.JavaBackendRestAPI.JavaBackendRestAPI.Entity.CourseInstance;
import com.JavaBackendRestAPI.JavaBackendRestAPI.Repositories.CourseInstanceRepository;
import com.JavaBackendRestAPI.JavaBackendRestAPI.ResourceNotFoundException;
import com.JavaBackendRestAPI.JavaBackendRestAPI.Service.CourseInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    @Autowired
    private CourseInstanceService courseInstanceService;

    @PostMapping
    public String createCourseInstance(@RequestBody CourseInstance instance) {
        boolean isCourseInstance = courseInstanceService.saveCourseInstance(instance);
        if(isCourseInstance){
            return "Course instance saved successfully";
        }
        return "Course instance not saved";
    }

    @GetMapping("/{year_of_delivery}/{semester}")
    public List<CourseInstance> getInstancesByYearAndSemester(@PathVariable String year_of_delivery, @PathVariable String semester) {
        return courseInstanceRepository.findByYearAndSemester(year_of_delivery, semester);
    }

    @GetMapping("/{year_of_delivery}/{semester}/{id}")
    public ResponseEntity<CourseInstance> getInstanceById(
            @PathVariable String year_of_delivery,
            @PathVariable String semester,
            @PathVariable Long id) {
        CourseInstance instance = courseInstanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CourseInstance not found with id " + id));
        return ResponseEntity.ok(instance);
    }


    @DeleteMapping("/{year_of_delivery}/{semester}/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteInstance(@PathVariable String year_of_delivery, @PathVariable String semester, @PathVariable Long id) {
        CourseInstance instance = courseInstanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CourseInstance not found with id " + id));

        courseInstanceRepository.delete(instance);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
