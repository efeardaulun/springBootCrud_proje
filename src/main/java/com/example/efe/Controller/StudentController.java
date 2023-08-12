package com.example.efe.Controller;

import com.example.efe.Entity.Student;
import com.example.efe.Excepcition.ResourceNotFoundException;
import com.example.efe.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    //get all users
    @GetMapping()
    public List <Student> getAllUsers(){
        return studentRepository.findAll();
    }

    @GetMapping("/{studentId}")
    public Student findById(@PathVariable(value = "studentId") int studentId){
        return studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("user not found by user id"));

    }
    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student studentId){
        return studentRepository.save(studentId);
    }

    @PutMapping("/update/{studentId}")
    public Student updateStudent(@RequestBody Student user, @PathVariable(value = "studentId") int studentId){
        Student updatedUser = studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("user not found by id"));
        updatedUser.setStudentFirstname(user.getStudentFirstname());
        updatedUser.setStudentLastname(user.getStudentLastname());
        updatedUser.setStudentEmail(user.getStudentEmail());
        updatedUser.setCourses(user.getCourses());
        return studentRepository.save(updatedUser);
    }

    @DeleteMapping("/delete/{studentId}")
    public String deletedStudent(@PathVariable(value = "studentId") int studentId){
        Student deletedUser = studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("user not found by id"));
        studentRepository.delete(deletedUser);
        return "Users deleted";
    }
}
