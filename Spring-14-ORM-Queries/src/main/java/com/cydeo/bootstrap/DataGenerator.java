package com.cydeo.bootstrap;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("---------- REGION START ------------");

        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContains: " + regionRepository.findByCountryContains("United"));
        System.out.println("findByCountryContainsOrderByCountry: " + regionRepository.findByCountryContainsOrderByCountry("Asia"));
        System.out.println("findTopByCountry: " + regionRepository.findTop2ByCountry("Canada"));

        System.out.println("---------- REGION END ------------");

        System.out.println("---------- DEPARTMENT START ------------");

        System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivisionIs: " + departmentRepository.findByDivisionIs("Toys"));
        System.out.println("findByDivisionEquals: " + departmentRepository.findByDivisionEquals("Outdoor"));
        System.out.println("findDistinctTop3ByDivisionContains: " + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));



        System.out.println("---------- DEPARTMENT END ------------");

        System.out.println("---------- EMPLOYEE START ------------");

        System.out.println("findByDepartment: " + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivisionIs: " + departmentRepository.findByDivisionIs("Toys"));



        System.out.println("---------- EMPLOYEE END ------------");

    }
}
