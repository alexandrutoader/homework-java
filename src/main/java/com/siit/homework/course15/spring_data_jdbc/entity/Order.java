package com.siit.homework.course15.spring_data_jdbc.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Data
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderNumber;

    private String orderDate;

    private String requiredDate;

    private String shippedDate;

    private String status;

    private String comments;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber")
    private int customerNumber;
}
