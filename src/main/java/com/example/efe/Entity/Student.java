package com.example.efe.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private int studentId;
    private String studentFirstname;
    private String studentLastname;
    private String studentEmail;


    @OneToMany(targetEntity = EnrolledCourse.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_fk", referencedColumnName = "studentId")
    private List<EnrolledCourse> enrolledCourses = new ArrayList<>();

    /*
    @OneToMany(targetEntity = EnrolledCourse.class, cascade = CascadeType.ALL)
    private List<EnrolledCourse> enrolledCourses;
     */

    public Student(int id, String firstname, String lastname, String email) {
        this.studentId = id;
        this.studentFirstname = firstname;
        this.studentLastname = lastname;
        this.studentEmail = email;

    }

    public Student(int studentId, String studentFirstname, String studentLastname, String studentEmail, List<EnrolledCourse> enrolledCourses) {
        this.studentId = studentId;
        this.studentFirstname = studentFirstname;
        this.studentLastname = studentLastname;
        this.studentEmail = studentEmail;
        this.enrolledCourses = enrolledCourses;
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

    public List<EnrolledCourse> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<EnrolledCourse> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}
