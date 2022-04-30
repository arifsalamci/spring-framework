package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {


    List<Department> findByDepartment(String department);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);
    List<Department> findDistinctTop3ByDivisionContains(String division);
    @Query("SELECT d FROM Department d WHERE d.division IN ?1")
    List<Department> getDepartmentByDivision(List<String> division);

    List<Department> retrieveDepartmentByDivision(String division);
    @Query(nativeQuery = true)
    List<Department> retrieveDepartmentByDivisionContain(String pattern);

}
