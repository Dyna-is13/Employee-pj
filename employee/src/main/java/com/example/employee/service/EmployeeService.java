//package com.example.employee.service;
//
//import com.example.employee.entity.Employee;
//import com.example.employee.exception.NotFoundException;
//import com.example.employee.repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class EmployeeService {
//    @Autowired
//    EmployeeRepository employeeRepository;
//
//    //Get all Employees
//    public List<Employee> getAllEmployees() {
//        return employeeRepository.findAll();
//    }
//
//    //Create an Employee
//    public Employee createAnEmployee(Employee employee) {
//        return employeeRepository.save(employee);
//    }
//
//    //Find an Employee by ID
//    public Employee findAnEmployeeById(Long id) {
//        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException(""));
//    }
//
//    //Update an Employee by ID
//    public Employee updateAnEmployeeById(Long id, Employee employee) {
//        Employee currentEmployee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException(""));
//        currentEmployee.setFullName(employee.getFullName());
//        currentEmployee.setYearOfBirth(employee.getYearOfBirth());
//        currentEmployee.setGender(employee.getGender());
//        currentEmployee.setPob(employee.getPob());
//        currentEmployee.setEmail(employee.getEmail());
//        Employee employee1;
//        return employee1 = employeeRepository.save(currentEmployee);
//    }
//
//    //Delete an Employee by ID
//    public HttpStatus deleteAnEmployeeById(Long id) {
//        employeeRepository.deleteById(id);
//        return HttpStatus.NO_CONTENT;
//    }
//
//    //Get all Employees with pagination
//    public Page<Employee> getAllEmployeesWithPagination(int pageNO, int pageSize) {
//        Pageable pageable = PageRequest.of(pageNO, pageSize);
//        return employeeRepository.findAll(pageable);
//    }
//
//    //Get all Employees by gender with pagination
//    public Page<Employee> findAllEmployeesByGender(String gender, int pageN, int pageS) {
//        Pageable pageable = PageRequest.of(pageN, pageS);
//        return employeeRepository.findAllEmployeesByGender(gender, pageable);
//    }
//
//    //Find Employees by fullName
//    public List<Employee> findEmployeesByName(String name) {
//        return employeeRepository.findEmployeesByName(name);
//    }
//}
