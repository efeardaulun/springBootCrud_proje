package com.example.efe.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String studentFirstname;
    private String studentLastname;
    private String studentEmail;

    @ManyToMany()
    @JoinTable(name = "enrolledCourse",
    joinColumns = {
            @JoinColumn(name = "student_id",referencedColumnName = "id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "course_id",referencedColumnName = "id")
    }
    )
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Course> courses;


    public Student() {
        super();
    }

    public Student(Long studentId, String studentFirstname, String studentLastname, String studentEmail, Set<Course> courses) {
        this.id = studentId;
        this.studentFirstname = studentFirstname;
        this.studentLastname = studentLastname;
        this.studentEmail = studentEmail;
        this.courses = courses;
    }

    public Student(Long id, String firstname, String lastname, String email) {
        this.id = id;
        this.studentFirstname = firstname;
        this.studentLastname = lastname;
        this.studentEmail = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentFirstname() {
        return studentFirstname;
    }

    public void setStudentFirstname(String firstname) {
        this.studentFirstname = firstname;
    }

    public String getStudentLastname() {
        return studentLastname;
    }

    public void setStudentLastname(String lastname) {
        this.studentLastname = lastname;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String email) {
        this.studentEmail = email;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
