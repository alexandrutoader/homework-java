package com.siit.homework.course15.spring_data_jdbc.repository;

import com.siit.homework.course15.spring_data_jdbc.entity.Product;

import java.util.List;

public interface ProductDAORepository {
    void save(Product product);

    List<Product> findByOrderId(String productCode);

    void update(Product product);

    void delete(String productCode);
}
