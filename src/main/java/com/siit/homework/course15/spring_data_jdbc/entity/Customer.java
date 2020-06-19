package com.siit.homework.course15.spring_data_jdbc.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerNumber;

    private String customerName;

    private String contactLastName;

    private String contactFirstName;

    private String phone;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String postalCode;

    private String country;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "salesRepEmployeeNumber", referencedColumnName = "salesRepEmployeeNumber")
    private Employee employee;

}
