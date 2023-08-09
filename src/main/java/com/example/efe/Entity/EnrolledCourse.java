package com.example.efe.Entity;

import jakarta.persistence.*;

@Table(name = "EnrolledCourse")
@Entity
public class EnrolledCourse {
/*
    @ManyToMany
    @JoinColumn(name = "id")
    private Course courseId;
*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enrolledCourseId;

    /*
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;
    */




}
