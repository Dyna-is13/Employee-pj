package com.example.employee.controller;

import com.example.employee.entity.Employee;
import com.example.employee.entity.EmployeeDto;
import com.example.employee.service.EmployeeDtoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeDtoController {

    @Autowired
    private EmployeeDtoService employeeService;

    //Get all of EmployeeDto
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> findAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    //Find an EmployeeDto by Gender with pagination
    @GetMapping("/find/{gender}")
    public ResponseEntity<Page<EmployeeDto>> findByGenderPagination(
            @PathVariable String gender,
            @RequestParam(defaultValue = "0") int pageN,
            @RequestParam(defaultValue = "5") int pageS
    ) {
        Page<EmployeeDto> employees = employeeService.findEmployeeDtoByGender(gender, pageN, pageS);
        return ResponseEntity.ok(employees);
    }

    //find an EmployeeDto by ID
    @GetMapping("/findId/{id}")
    public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findAnEmployeeDtoById(id));
    }

    //Get all of EmployeeDto order by name with pagination
    @GetMapping("/orderByName")
    public ResponseEntity<Page<EmployeeDto>> findAllOrderByFullName(
            @RequestParam(defaultValue = "0") int pageN,
            @RequestParam(defaultValue = "5") int pageS
    ) {
        Page<EmployeeDto> employees = employeeService.getAllEmployeeDtoOrderByName(pageN, pageS);
        return ResponseEntity.ok(employees);
    }

    //Get all of EmployeeDto order by year of birth with pagination
    @GetMapping("/orderByYear")
    public ResponseEntity<Page<EmployeeDto>> findAllOrderByYearOfBirth(
            @RequestParam(defaultValue = "0") int pageN,
            @RequestParam(defaultValue = "5") int pageS
    ) {
        Page<EmployeeDto> employees = employeeService.getAllEmployeeDtoOrderByYearOfBirth(pageN, pageS);
        return ResponseEntity.ok(employees);
    }

    //Find an EmployeeDto by fullName
    @GetMapping("/findFullName/{name}")
    public ResponseEntity<List<EmployeeDto>> findEmployeeByFullName(@PathVariable String name) {
        return new ResponseEntity<>(employeeService.findAnEmployeeDtoByFullName(name), HttpStatus.OK);
    }

    //Create an Employee
    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    //Update an Employee by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateAnEmployeeById(id, employee), HttpStatus.OK);
    }

    //Delete an Employee by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.deleteAnEmployeeById(id), HttpStatus.NO_CONTENT);
    }


}
