package com.example.efe.Controller;

import com.example.efe.Entity.Course;
import com.example.efe.Excepcition.ResourceNotFoundException;
import com.example.efe.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping
    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    @GetMapping("/{courseId}")
    public Course findById(@PathVariable (value = "courseId") int id){
        return courseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("course not found by id"));
    }

    @PostMapping("/save")
    public Course saveCourse(@RequestBody Course course){
        return courseRepository.save(course);
    }

    @PutMapping("/update/{courseId}")
    public Course updateCourse(@RequestBody Course course, @PathVariable(value = "courseId") int id){
        Course updatedCourse = courseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("course not found by id"));
        updatedCourse.setCourseName(course.getCourseName());
        updatedCourse.setIsMathematical(course.isMathematical());
        updatedCourse.setIsVerbal(course.isVerbal());
        return courseRepository.save(updatedCourse);
    }

    @DeleteMapping("/delete/{courseId}")
    public String deleteCourse(@PathVariable(value = "courseId") int id){
        courseRepository.deleteById(id);
        return "course deletede";
    }
}
