package com.example.employee.service;

import com.example.employee.entity.Employee;
import com.example.employee.entity.EmployeeDto;
import com.example.employee.exception.NotFoundException;
import com.example.employee.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeDtoService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private MapperService mapperService;

    //Get all of EmployeeDto
    public List<EmployeeDto> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        return mapperService.convertListEntityToDto(employees, EmployeeDto.class);
    }

    //Find an EmployeeDto by Gender with pagination
    public Page<EmployeeDto> findEmployeeDtoByGender(String gender, int pageN, int pageS) {
        Pageable pageable = PageRequest.of(pageN, pageS);
        Page<Employee> employees = employeeRepository.findAllEmployeesByGender(gender, pageable);
        return mapperService.mapEntityPageIntoDtoPage(employees, EmployeeDto.class);
    }

    //Get all of EmployeeDto order by name with pagination
    public Page<EmployeeDto> getAllEmployeeDtoOrderByName(int pageN, int pageS) {
        Pageable pageable = PageRequest.of(pageN, pageS);
        Page<Employee> employees = employeeRepository.findAllOrderByLevelDesc(pageable);
        return mapperService.mapEntityPageIntoDtoPage(employees, EmployeeDto.class);
    }

    //Get all of EmployeeDto order by year of birth with pagination
    public Page<EmployeeDto> getAllEmployeeDtoOrderByYearOfBirth(int pageN, int pageS) {
        Pageable pageable = PageRequest.of(pageN, pageS);
        Page<Employee> employees = employeeRepository.findAllOrderByYearOfBirth(pageable);
        return mapperService.mapEntityPageIntoDtoPage(employees, EmployeeDto.class);
    }

    //Find an EmployeeDto by fullName
    public List<EmployeeDto> findAnEmployeeDtoByFullName(String name) {
        List<Employee> employee = employeeRepository.findEmployeeByFullName(name);
        return mapperService.convertListEntityToDto(employee, EmployeeDto.class);
    }

    //Create an Employee
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    //Update an Employee by ID
    public Employee updateAnEmployeeById(Long id, Employee employee) {
        Employee currentEmployee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException(""));
        currentEmployee.setFullName(employee.getFullName());
        currentEmployee.setYearOfBirth(employee.getYearOfBirth());
        currentEmployee.setGender(employee.getGender());
        currentEmployee.setPob(employee.getPob());
        currentEmployee.setEmail(employee.getEmail());
        Employee employee1;
        return employee1 = employeeRepository.save(currentEmployee);
    }

    //Delete an Employee by ID
    public HttpStatus deleteAnEmployeeById(Long id) {
        employeeRepository.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }

    //find an EmployeeDto by ID
    public EmployeeDto findAnEmployeeDtoById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException(""));
        return mapperService.convertEntityToDto(employee, EmployeeDto.class);
    }

}
