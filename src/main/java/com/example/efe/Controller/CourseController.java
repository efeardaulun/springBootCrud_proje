package com.example.efe.Controller;

import com.example.efe.Entity.Course;
import com.example.efe.Entity.Instructor;
import com.example.efe.Excepcition.ResourceNotFoundException;
import com.example.efe.Repository.CourseRepository;
import com.example.efe.Repository.InstructorRepository;
import com.example.efe.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    InstructorRepository instructorRepository;

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
    @ResponseStatus(HttpStatus.CREATED)
    public Response saveCourse(@RequestBody Course course){
        if (course != null && course.getInstructor() != null){
            if (course.getInstructor().getId() != null){
                setExistingInstructorToCourse(course);
            }
            else if(course.getInstructor().getInstructorName() != null && course.getInstructor().getInstructorSurname() != null){
                saveNewInstructor(course);
            }
        }
        courseRepository.save(course);
        return new Response("created success",HttpStatus.CREATED.value());

    }

    private void setExistingInstructorToCourse(Course course){
        Instructor instructor = instructorRepository.findById(course.getInstructor().getId()).orElse(null);
        if (instructor != null){
            course.setInstructor(instructor);
        }
    }

    private void saveNewInstructor(Course course){
        Instructor instructor = new Instructor(course.getInstructor().getInstructorName(),course.getInstructor().getInstructorSurname());
        course.setInstructor(instructorRepository.save(instructor));
    }

    @PutMapping("/update/{courseId}")
    public Course updateCourse(@RequestBody Course course, @PathVariable(value = "courseId") int id){
        Course updatedCourse = courseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("course not found by id"));
        updatedCourse.setCourseName(course.getCourseName());
        updatedCourse.setIsMathematical(course.isMathematical());
        return courseRepository.save(updatedCourse);
    }

    @DeleteMapping("/delete/{courseId}")
    public String deleteCourse(@PathVariable(value = "courseId") int id){
        courseRepository.deleteById(id);
        return "course deletede";
    }
}
