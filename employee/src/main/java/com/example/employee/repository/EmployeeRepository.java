package com.example.employee.repository;

import com.example.employee.entity.Employee;
import com.example.employee.entity.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("SELECT e FROM Employee e WHERE e.gender=?1")
    Page<Employee> findAllEmployeesByGender(String gender, Pageable pageable);

    @Query("SELECT e FROM Employee e WHERE e.fullName LIKE %?1%")
    List<Employee> findEmployeesByName(String name);

    @Query("SELECT e FROM Employee e WHERE e.gender=?1")
    List<Employee> findAllEmployeesByGender(String gender);

    @Query("SELECT e FROM Employee e ORDER BY e.fullName ASC")
    Page<Employee> findAllOrderByLevelDesc(Pageable pageable);

    @Query("SELECT e FROM Employee e ORDER BY e.yearOfBirth DESC")
    Page<Employee> findAllOrderByYearOfBirth(Pageable pageable);

    @Query("SELECT e FROM Employee e WHERE e.fullName LIKE %?1%")
    List<Employee> findEmployeeByFullName(String fullName);
}
