package com.example.efe.Controller;

import com.example.efe.Entity.Instructor;
import com.example.efe.Entity.Student;
import com.example.efe.Excepcition.ResourceNotFoundException;
import com.example.efe.Repository.CourseRepository;
import com.example.efe.Repository.InstructorRepository;
import com.example.efe.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//mail ekledim coursuna kayıt olunursa instructora mail gitsin
//
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
    @ResponseStatus(HttpStatus.CREATED)
    public Response saveInstructor (@RequestBody Instructor instructor){
        instructorRepository.save(instructor);
        return new Response("instructor saved",HttpStatus.OK.value());
    }

    @PutMapping("/update/{instructorId}")
    @ResponseStatus(HttpStatus.OK)
    public Response updateInstructor(@RequestBody Instructor instructor, @PathVariable(value = "instructorId") Long id){
        Instructor updatedInstructor = instructorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("instructor not found by id"));
        updatedInstructor.setInstructorName(instructor.getInstructorName());
        updatedInstructor.setInstructorSurname(instructor.getInstructorSurname());
        updatedInstructor.setEmail(instructor.getEmail());
        instructorRepository.save(updatedInstructor);
        return new Response("instrucor updated", HttpStatus.OK.value());
    }

    @DeleteMapping("/delete/{instructorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Response deleteInstructor(@PathVariable(value = "instructorId") Long id){
        Instructor deletedInstructor = instructorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("instructor not found by id"));
        instructorRepository.delete(deletedInstructor);
        return new Response("Instructor Deleted",HttpStatus.NO_CONTENT.value());
    }

}


