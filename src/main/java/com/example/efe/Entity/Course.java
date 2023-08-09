package com.example.efe.Entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "Course")
@Entity
public class Course {
    //id,isim,is_sayısal mı,is_mathemetical,instructorid

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseName;
    private boolean isMathematical;
    private boolean isVerbal;
    /*
     @OneToMany(targetEntity = EnrolledCourse.class, cascade = CascadeType.ALL)
     private List<EnrolledCourse> enrolledCourseList;
     */

    @OneToMany(targetEntity = EnrolledCourse.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_fk", referencedColumnName = "courseId")
    private List<EnrolledCourse> enrolledCourseList = new ArrayList<>();

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

    public void setMathematical(boolean mathematical) {
        isMathematical = mathematical;
    }

    public boolean isVerbal() {
        return isVerbal;
    }

    public void setVerbal(boolean verbal) {
        isVerbal = verbal;
    }

    public List<EnrolledCourse> getEnrolledCourseList() {
        return enrolledCourseList;
    }

    public void setEnrolledCourseList(List<EnrolledCourse> enrolledCourseList) {
        this.enrolledCourseList = enrolledCourseList;
    }
}
