package com.example.efe.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private int studentId;
    private String studentFirstname;
    private String studentLastname;
    private String studentEmail;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "enrolledCourse",
    joinColumns = {
            @JoinColumn(name = "student_id",referencedColumnName = "studentId")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "course_id",referencedColumnName = "courseId")
    }
    )
    private Set<Course> courses;


    public Student(int studentId, String studentFirstname, String studentLastname, String studentEmail, Set<Course> courses) {
        this.studentId = studentId;
        this.studentFirstname = studentFirstname;
        this.studentLastname = studentLastname;
        this.studentEmail = studentEmail;
        this.courses = courses;
    }

    public Student(int id, String firstname, String lastname, String email) {
        this.studentId = id;
        this.studentFirstname = firstname;
        this.studentLastname = lastname;
        this.studentEmail = email;

    }

    public Student() {
        super();
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int id) {
        this.studentId = id;
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
