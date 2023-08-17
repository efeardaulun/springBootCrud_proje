package com.example.efe.Controller;

import com.example.efe.Entity.Course;
import com.example.efe.Entity.Student;
import com.example.efe.Excepcition.ResourceNotFoundException;
import com.example.efe.Repository.CourseRepository;
import com.example.efe.Repository.StudentRepository;
import com.example.efe.Response;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;

    //get all users
    @GetMapping()
    public List <Student> getAllUsers(){
        return studentRepository.findAll();
    }

    @GetMapping("/{studentId}")
    public Student findById(@PathVariable(value = "studentId") Long studentId){
        return studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("user not found by user id"));

    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Response saveStudentWithCourses(@RequestBody Student student) {
        if (student != null && student.getCourses() != null) {
            for (Course course : student.getCourses()) {
                if (course.getId() != null) {
                    Hibernate.initialize(course);
                    student.getCourses().add(course);
                }
            }
            Student savedStudent = studentRepository.save(student);
            return new Response("created success", HttpStatus.CREATED.value());
        }
        else
            return new Response("only enroll already existing course", HttpStatus.INTERNAL_SERVER_ERROR.value());
    }



    @PutMapping("/update/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public Response updateStudent(@RequestBody Student user, @PathVariable(value = "studentId") Long studentId){
        Student updatedUser = studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("user not found by id"));
        updatedUser.setStudentFirstname(user.getStudentFirstname());
        updatedUser.setStudentLastname(user.getStudentLastname());
        updatedUser.setStudentEmail(user.getStudentEmail());
        updatedUser.setCourses(user.getCourses());
        studentRepository.save(updatedUser);
        return new Response("user updated",HttpStatus.OK.value());
    }

    @DeleteMapping("/delete/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Response deletedStudent(@PathVariable(value = "studentId") Long studentId){
        Student deletedUser = studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("user not found by id"));
        studentRepository.delete(deletedUser);
        return new Response("user deletede", HttpStatus.NO_CONTENT.value());
    }
}
