package spring_basic.spring_basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_basic.spring_basic.dto.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}