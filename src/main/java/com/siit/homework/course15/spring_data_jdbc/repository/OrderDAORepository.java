package com.siit.homework.course15.spring_data_jdbc.repository;

import com.siit.homework.course15.spring_data_jdbc.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderDAORepository {
    void save(Order order);

    List<Order> findByOrderId(int orderId);

    void update(Order order);

    void delete(int orderId);
}
