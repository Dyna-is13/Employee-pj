//package com.example.employee;
//
//import com.example.employee.entity.Employee;
//import com.example.employee.entity.EmployeeDto;
//import com.example.employee.repository.EmployeeRepository;
//import com.example.employee.service.EmployeeDtoService;
//import org.aspectj.lang.annotation.After;
//import org.junit.jupiter.api.*;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.List;
//
//
//@SpringBootTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
//public class EmployeeTest {
//    @Autowired
//    private EmployeeRepository repository;
//    public void createEmployee(){
//        //arrange
//        Employee employee = Employee.builder()
//                .fullName("Lola")
//                .yearOfBirth(2000)
//                .gender("Female")
//                .pob("Hawaii")
//                .email("lla@gmail.com")
//                .build();
//        //act
//        Employee saveEmployee = employeeRepository.save(employee);
//
//        //assert
//        Assertions.assertThat
//    }
//
//
//
//}
