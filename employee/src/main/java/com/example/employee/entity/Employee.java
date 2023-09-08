package com.example.employee.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2,message = "name should has at least 4 characters")
    private String fullName;
    @NotNull
    private int yearOfBirth;   //year of birth
    @NotNull
    @Size(min = 2,message = "gender should has at least 4 characters")
    private String gender;
    @NotNull
    @Size(min = 2,message = "place of birth should has at least two characters")
    private String pob; //place of birth
    @NotNull
    @Email
    private String email;

}
