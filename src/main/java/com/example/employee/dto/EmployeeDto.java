package com.example.employee.dto;

import lombok.Data;

import java.util.Set;

@Data
public class EmployeeDto {
    Long id;
    String firstName;
    String lastName;
    String emailId;
    Set<Long> departments;
}
