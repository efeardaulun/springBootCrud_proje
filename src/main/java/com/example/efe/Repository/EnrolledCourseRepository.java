package com.example.efe.Repository;

import com.example.efe.Entity.EnrolledCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolledCourseRepository extends JpaRepository<EnrolledCourse, Integer> {
}
