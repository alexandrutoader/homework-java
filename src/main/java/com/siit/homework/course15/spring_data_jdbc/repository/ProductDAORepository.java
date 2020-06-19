package com.siit.homework.course15.spring_data_jdbc.repository;

import com.siit.homework.course15.spring_data_jdbc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAORepository extends JpaRepository<Product, Integer> {
    @Query("SELECT * " +
            "FROM products p " +
            "WHERE p.productCode = :productCode")
    List<Product> findAllByProductCode(@Param("orderNumber") Integer orderNumber);

    @Query("DELETE " +
            "FROM products " +
            "WHERE productCode = :productCode")
    void delete(@Param("productCode") String productCode);

    void save();

    void update();
}
