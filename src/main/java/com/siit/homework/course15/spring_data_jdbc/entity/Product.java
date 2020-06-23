package com.siit.homework.course15.spring_data_jdbc.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private String productCode;

    private String productName;

    private String productLine;

    private String productScale;

    private String productVendor;

    private String productDescription;

    private int quantityInStock;

    private BigDecimal buyPrice;

    @Column(name = "MSRP")
    private BigDecimal msrp;
}
