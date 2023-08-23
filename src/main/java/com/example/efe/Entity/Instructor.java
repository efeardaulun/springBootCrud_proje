package com.example.efe.Entity;

import jakarta.persistence.*;

@Entity
public class Instructor {
    //id,name,surname

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String instructorName;
    private  String instructorSurname;
    private String email;

    public Instructor() {
        super();
    }

    public Instructor(Long id, String instructorName, String instructorSurname, String email) {
        this.id = id;
        this.instructorName = instructorName;
        this.instructorSurname = instructorSurname;
        this.email = email;
    }

    public Instructor(String instructorName, String instructorSurname) {
        this.instructorName = instructorName;
        this.instructorSurname = instructorSurname;
    }

    public Instructor(Long instructorId, String instructorName, String instructorSurname) {
        this.id = instructorId;
        this.instructorName = instructorName;
        this.instructorSurname = instructorSurname;
    }

    public Long getId() { return id; }

    public void setId(Long instructorId) {
        this.id = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorSurname() {
        return instructorSurname;
    }

    public void setInstructorSurname(String instructorSurname) {
        this.instructorSurname = instructorSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
