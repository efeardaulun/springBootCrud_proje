package com.example.efe.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private int studentId;
    private String studentFirstname;
    private String studentLastname;
    private String studentEmail;

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
}
