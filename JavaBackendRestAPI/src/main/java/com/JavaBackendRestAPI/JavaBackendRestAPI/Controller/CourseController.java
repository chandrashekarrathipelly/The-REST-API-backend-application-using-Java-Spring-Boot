package com.JavaBackendRestAPI.JavaBackendRestAPI.Controller;

import com.JavaBackendRestAPI.JavaBackendRestAPI.Entity.Course;
import com.JavaBackendRestAPI.JavaBackendRestAPI.Repositories.CourseRepository;
import com.JavaBackendRestAPI.JavaBackendRestAPI.ResourceNotFoundException;
import com.JavaBackendRestAPI.JavaBackendRestAPI.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;
        @PostMapping
        public String createNewCourse(@RequestBody Course course) {
            boolean isCourseSaved =courseService.saveCourse(course);
            if(isCourseSaved){
                return "New course saved successfully";
            }
            return "New course not saved";
        }

        @GetMapping
        public List<Course> getAllCourses() {
            return courseRepository.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
            Course course = courseRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
            return ResponseEntity.ok(course);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Map<String, Boolean>> deleteCourse(@PathVariable Long id) {
            Course course = courseRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));

            courseRepository.delete(course);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return ResponseEntity.ok(response);
        }
}
