package com.example.efe.Controller;

import com.example.efe.Entity.Course;
import com.example.efe.Entity.Student;
import com.example.efe.Excepcition.ResourceNotFoundException;
import com.example.efe.Repository.CourseRepository;
import com.example.efe.Repository.StudentRepository;
import com.example.efe.Response;
import com.example.efe.Service.EmailSenderService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.Format;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    EmailSenderService emailSenderService;

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
        if (student != null && student.getCourses() != null ) {
            for (Course course : student.getCourses()) {
                if (course.getId() != null) {
                    Hibernate.initialize(course);
                    student.getCourses().add(course);
                    course = courseRepository.findById(course.getId()).orElse(null);
                    String instructorEmail = course.getInstructor().getEmail();
                    String formattedMessage = String.format("%s %s adlı öğrenci dersinize kaydolmuştur.", student.getStudentFirstname(), student.getStudentLastname());

                    emailSenderService.sendEmail(instructorEmail,"Ders Kaydı",formattedMessage);
                }
            }
            if (!student.getCourses().isEmpty()) {
                student.getCourses().clear();
            }
            studentRepository.save(student);
            return new Response("created success", HttpStatus.CREATED.value());
        }
        else
            studentRepository.save(student);
            return new Response("student registered without courses", HttpStatus.CREATED.value());
    }

    @PutMapping("/update/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public Response updateStudent(@RequestBody Student user, @PathVariable(value = "studentId") Long studentId){
        Student existingUser = studentRepository.findById(studentId)
                .orElseThrow(()-> new ResourceNotFoundException("user not found by id"));
        existingUser.setStudentFirstname(user.getStudentFirstname());
        existingUser.setStudentLastname(user.getStudentLastname());
        existingUser.setStudentEmail(user.getStudentEmail());

        Set<Course> newCourses = user.getCourses();
        Set<Course> existingCourses = existingUser.getCourses();

        for (Course newCourse : newCourses) {
            newCourse = courseRepository.findById(newCourse.getId()).orElse(null);

            if (newCourse != null && !existingCourses.contains(newCourse)) {
                if (newCourse.getInstructor() != null) {
                    String instructorEmail = newCourse.getInstructor().getEmail();
                    emailSenderService.sendEmail(instructorEmail, "Yeni Öğrenci Kaydı", "Yeni bir öğrenci dersinize kaydoldu.");
                }
            }
        }

        existingUser.setCourses(newCourses);

        studentRepository.save(existingUser);
        return new Response("user updated", HttpStatus.OK.value());
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
