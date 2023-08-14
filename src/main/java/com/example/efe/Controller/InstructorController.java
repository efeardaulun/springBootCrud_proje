package com.example.efe.Controller;

import com.example.efe.Entity.Instructor;
import com.example.efe.Entity.Student;
import com.example.efe.Excepcition.ResourceNotFoundException;
import com.example.efe.Repository.CourseRepository;
import com.example.efe.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    InstructorRepository instructorRepository;

    //private Instructor instructor;

    @GetMapping()
    public List<Instructor> findAll(){
        return instructorRepository.findAll();
    }

    @GetMapping("/{instructorId}")
    public Instructor findById(@PathVariable (value = "instructorId") Long id){
        return instructorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("instructor not found by user id"));
    }

    @PostMapping("/save")
    public Instructor saveInstructor (@RequestBody Instructor instructor){
        return instructorRepository.save(instructor);
    }

    @PutMapping("/update/{instructorId}")
    public Instructor updateInstructor(@RequestBody Instructor instructor, @PathVariable(value = "instructorId") Long id){
        Instructor updatedInstructor = instructorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("instructor not found by id"));
        updatedInstructor.setInstructorName(instructor.getInstructorName());
        updatedInstructor.setInstructorSurname(instructor.getInstructorSurname());
       // updatedInstructor.setCourseList(instructor.getCourseList());
        return instructorRepository.save(updatedInstructor);
    }

    @DeleteMapping("/delete/{instructorId}")
    public String deleteInstructor(@PathVariable(value = "instructorId") Long id){
        Instructor deletedInstructor = instructorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("instructor not found by id"));
        instructorRepository.delete(deletedInstructor);
        return "Instructor Deletede";
    }

}


