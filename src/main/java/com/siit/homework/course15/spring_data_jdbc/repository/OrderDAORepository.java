package com.siit.homework.course15.spring_data_jdbc.repository;

import com.siit.homework.course15.spring_data_jdbc.entity.Order;

import java.util.List;

public interface OrderDAORepository {
    void save(Order order);

    List<Order> findByOrderId(int orderId);

    void update(Order order);

    void delete(int orderId);
}
