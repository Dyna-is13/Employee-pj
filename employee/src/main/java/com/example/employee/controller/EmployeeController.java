//package com.example.employee.controller;
//
//import com.example.employee.entity.Employee;
//import com.example.employee.service.EmployeeService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/employees")
//public class EmployeeController {
//    @Autowired
//    EmployeeService employeeService;
//
//    //Get all Employees
//    @GetMapping("/all")
//    public ResponseEntity<List<Employee>> getAllEmployee() {
//        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
//    }
//
//    //Find an Employee by ID
//    @GetMapping("find/{id}")
//    public ResponseEntity<Employee> getAnEmployeeById(@PathVariable Long id) {
//        return new ResponseEntity<>(employeeService.findAnEmployeeById(id), HttpStatus.OK);
//    }
//
//    //Create an Employee
//    @PostMapping("/create")
//    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
//        return new ResponseEntity<>(employeeService.createAnEmployee(employee), HttpStatus.CREATED);
//    }
//
//    //Update an Employee by ID
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee) {
//        return new ResponseEntity<>(employeeService.updateAnEmployeeById(id, employee), HttpStatus.OK);
//    }
//
//    //Delete an Employee by ID
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id) {
//        return new ResponseEntity<>(employeeService.deleteAnEmployeeById(id), HttpStatus.NO_CONTENT);
//    }
//    //Get all Employees with pagination
//    @GetMapping("/getAll")
//    public ResponseEntity<Page<Employee>> getAllEmployeePagination(
//            @RequestParam(defaultValue = "0") int pageNO,
//            @RequestParam(defaultValue = "5") int pageSize
//    ) {
//        Page<Employee> employees = employeeService.getAllEmployeesWithPagination(pageNO, pageSize);
//        return ResponseEntity.ok(employees);
//    }
//    //Get all Employees by gender with pagination
//    @GetMapping("/get/{gender}")
//    public ResponseEntity<Page<Employee>> getAllFemaleEmployees(
//            @PathVariable String gender,
//            @RequestParam(defaultValue = "0") int pageN,
//            @RequestParam(defaultValue = "5") int pageS
//    ) {
//        Page<Employee> employees = employeeService.findAllEmployeesByGender(gender, pageN, pageS);
//        return ResponseEntity.ok(employees);
//    }
//    //Find Employees by fullName
//    @GetMapping("/findBy/{name}")
//    public ResponseEntity<List<Employee>> getEmployeesByName(@PathVariable String name){
//        return new ResponseEntity<>(employeeService.findEmployeesByName(name),HttpStatus.OK);
//    }
//
//}
