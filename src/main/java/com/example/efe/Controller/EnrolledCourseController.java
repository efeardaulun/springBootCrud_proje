package com.example.efe.Controller;

import com.example.efe.Entity.EnrolledCourse;
import com.example.efe.Repository.EnrolledCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coursesInfo")
public class EnrolledCourseController {

    @Autowired
    private EnrolledCourseRepository enrolledCourseRepository;

    @GetMapping
    public List<EnrolledCourse> getAll(){
        return enrolledCourseRepository.findAll();
    }

    @PostMapping("/save")
    public EnrolledCourse enrolCourse(@RequestBody EnrolledCourse enrolledCourse){
        return enrolledCourseRepository.save(enrolledCourse);
    }
}
