package com.example.efe.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Instructor")
public class Instructor {
    //id,name,surname

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int instructorId;
    private String instructorName;
    private  String instructorSurname;

    @OneToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "instructorCourse_fk", referencedColumnName = "instructorId")
    private List<Course> courseList = new ArrayList<>();

    public Instructor(int instructorId, String instructorName, String instructorSurname, List<Course> courseList) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.instructorSurname = instructorSurname;
        this.courseList = courseList;
    }

    public Instructor() {
        super();
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
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

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
