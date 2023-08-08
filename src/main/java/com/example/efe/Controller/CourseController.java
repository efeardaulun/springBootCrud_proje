package com.example.efe.Controller;

import com.example.efe.Entity.Instructor;
import com.example.efe.Repository.CourseRepository;
import com.example.efe.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    InstructorRepository instructorRepository;


    private Instructor instructor;

    @PostMapping("/kaydet")
    public Instructor efee (@RequestBody Instructor instructorLesson){
        return instructorRepository.save(instructorLesson);
    }

    @GetMapping("/findall")
    public List<Instructor> findAll(){
        return instructorRepository.findAll();
    }
}


