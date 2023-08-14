package com.example.efe.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Instructor")
public class Instructor {
    //id,name,surname

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String instructorName;
    private  String instructorSurname;


    /*
    @OneToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
    @NonNull
    private List<Course> courseList = new ArrayList<>();

     */

    /*
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Course> courseList = new ArrayList<>();

     */

    public Instructor(String instructorName, String instructorSurname) {
        this.instructorName = instructorName;
        this.instructorSurname = instructorSurname;
    }

    public Instructor(Long instructorId, String instructorName, String instructorSurname) {
        this.id = instructorId;
        this.instructorName = instructorName;
        this.instructorSurname = instructorSurname;
    }

    public Instructor() {
        super();
    }

    public Long getId() {
        return id;
    }

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

}
