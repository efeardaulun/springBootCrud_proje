package com.example.efe.Entity;


import jakarta.persistence.*;

import java.util.Set;

@Table(name = "Course")
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseName;
    private boolean isMathematical;
    private boolean isVerbal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructorId")
    private Instructor instructor;


    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private Set<Student> students;


    public Course(int courseId, String courseName, boolean isMathematical, boolean isVerbal) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.isMathematical = isMathematical;
        this.isVerbal = isVerbal;
    }

    public Course() {
        super();
    }


    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    public boolean isVerbal() {
        return isVerbal;
    }

    public void setIsVerbal(boolean isVerbal) {
        this.isVerbal = isVerbal;
    }

}
