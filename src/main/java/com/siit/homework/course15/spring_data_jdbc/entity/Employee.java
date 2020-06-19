package com.siit.homework.course15.spring_data_jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeNumber;

    private String lastName;

    private String firstName;

    private String extension;

    private String email;

    private String officeCode;

    private int reportsTo;

    private String jobTitle;
}
