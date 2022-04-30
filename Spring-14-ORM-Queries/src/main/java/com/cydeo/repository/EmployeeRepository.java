package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    List<Employee> findByEmail(String email);
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);
    List<Employee> findByFirstNameIsNot(String firstName);
    List<Employee> findByLastNameStartingWith(String lastName);
    List<Employee> findBySalaryGreaterThan(Integer salary);
    List<Employee> findBySalaryLessThanEqual(Integer salary);
    List<Employee> findByHireDateBetween(LocalDate start, LocalDate endDate);
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);
    List<Employee> findByEmailIsNull();

    @Query("SELECT e FROM Employee e where e.email='sdubber7@t-online.de'")
    Employee getEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e where e.email='sdubber7@t-online.de'")
    Integer getEmployeeSalary();

    @Query("SELECT e.salary FROM Employee e where e.email=?1")
    Optional<Employee> getEmployeeByEmail(String email);

    @Query("SELECT e.salary FROM Employee e where e.email=?1 and e.salary=?2")
    Employee getEmployeeDetail(String email, Integer salary);

    @Query("SELECT e FROM Employee e WHERE e.salary<>?1")
    List<Employee> getEmployeeBySalaryNot(int salary);

    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> getEmployeeByFirstNameLike(String pattern);

    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> getEmployeeBySalaryLessThan(int salary);

    @Query("SELECT e FROM Employee e WHERE e.salary > ?1")
    List<Employee> getEmployeeBySalaryGreaterThan(int salary);

    @Query("SELECT e FROM Employee e WHERE e.hireDate < ?1")
    List<Employee> getEmployeeByHireDateBefore(LocalDate date);

    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> getEmployeeBySalaryBetween(int salary1, int salary2);

    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> getEmployeeEmailIsNull();

    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> getEmployeeEmailIsNotNull();

    @Query("SELECT e FROM Employee e ORDER BY e.salary")
    List<Employee> getEmployeeSalaryOrderAsc();

    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC")
    List<Employee> getEmployeeSalaryOrderDesc();

    @Query(value = "SELECT * FROM Employees WHERE salary=?1", nativeQuery = true)
    List<Employee> readEmployeeDetailBySalary(int salary);

    @Query("SELECT e FROM Employee e WHERE e.salary= :salary")
    List<Employee> getEmployeeBySalary(@Param("salary") int salary);

}
