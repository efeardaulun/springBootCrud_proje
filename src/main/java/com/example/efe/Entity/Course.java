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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructorId", referencedColumnName = "id")
    private Instructor instructor;

<<<<<<< HEAD


    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private Set<Student> students;


    public Course(int courseId, String courseName, boolean isMathematical, Instructor instructor, Set<Student> students) {
        this.courseId = courseId;
=======
    @ManyToMany()
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Student> students;


    public Course(Long courseId, String courseName, boolean isMathematical, Set<Student> students) {
        this.id = courseId;
        this.courseName = courseName;
        this.isMathematical = isMathematical;
        this.students = students;
    }

    public Course(Long courseId, String courseName, boolean isMathematical, Instructor instructor, Set<Student> students) {
        this.id = courseId;
>>>>>>> e06a8dd (endpoints are working, bugs fixed mail features added)
        this.courseName = courseName;
        this.isMathematical = isMathematical;
        this.instructor = instructor;
        this.students = students;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Course(int courseId, String courseName, boolean isMathematical, Set<Student> students) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.isMathematical = isMathematical;

        this.students = students;
    }

    public Course(int courseId, String courseName, boolean isMathematical) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.isMathematical = isMathematical;

    }

    public Course() {
        super();
    }

<<<<<<< HEAD

    public int getCourseId() {
        return courseId;
=======
    public Long getId() {
        return id;
>>>>>>> e06a8dd (endpoints are working, bugs fixed mail features added)
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

<<<<<<< HEAD

=======
>>>>>>> e06a8dd (endpoints are working, bugs fixed mail features added)
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }


}
