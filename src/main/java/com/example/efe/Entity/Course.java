package com.example.efe.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private boolean isMathematical;

    @ManyToOne()
    @JoinColumn(name = "instructorId", referencedColumnName = "id")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Instructor instructor;

    @ManyToMany()
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Student> students;


    public Course(Long courseId, String courseName, boolean isMathematical, Set<Student> students) {
        this.id = courseId;
        this.courseName = courseName;
        this.isMathematical = isMathematical;
        this.students = students;
    }

    public Course(Long courseId, String courseName, boolean isMathematical, Instructor instructor, Set<Student> students) {
        this.id = courseId;
        this.courseName = courseName;
        this.isMathematical = isMathematical;
        this.instructor = instructor;
        this.students = students;
    }

    public Course(Long courseId, String courseName, boolean isMathematical) {
        this.id = courseId;
        this.courseName = courseName;
        this.isMathematical = isMathematical;

    }

    public Course(Long id, String courseName, boolean isMathematical, Instructor instructor) {
        this.id = id;
        this.courseName = courseName;
        this.isMathematical = isMathematical;
        this.instructor = instructor;
    }

    public Course() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long courseId) {
        this.id = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public boolean isMathematical() {
        return isMathematical;
    }

    public void setIsMathematical(boolean isMathematical) {
        this.isMathematical = isMathematical;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

}
