package com.siit.homework.course15.spring_data_jdbc.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@Entity
@Table(name = "orderdetails")
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderNumber;

    private String productCode;

    private int quantityOrdered;

    private BigDecimal priceEach;

    private int orderLineNumber;

    @ToString.Exclude
    @OneToMany(mappedBy = "product")
    private List<Product> products;
}
