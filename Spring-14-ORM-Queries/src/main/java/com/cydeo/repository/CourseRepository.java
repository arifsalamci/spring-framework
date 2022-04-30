package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;


public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByCategory(String category);

    List<Course> findByCategoryOrderByName(String Category);

    Boolean existsByName(String name);

    int countCourseByCategory(String category);

    List<Course> findAllByNameStartingWith(String pattern);

    Stream<Course> streamByCategory(String category);

    @Query("SELECT c FROM Course c WHERE c.category = :category AND c.category > :rating")
    List<Course> findAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating)

}
