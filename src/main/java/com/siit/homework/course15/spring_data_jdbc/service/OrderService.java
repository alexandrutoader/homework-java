package com.siit.homework.course15.spring_data_jdbc.service;

import com.siit.homework.course15.spring_data_jdbc.entity.Order;
import com.siit.homework.course15.spring_data_jdbc.repository.OrderDAORepository;
import com.siit.homework.course15.spring_data_jdbc.repository.OrderDAORepositoryImpl;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class OrderService {
    private final OrderDAORepository orderDAORepository;

    public void create(Order order) {
        orderDAORepository.save(order);
    }

    public void delete(int orderId) {
        orderDAORepository.delete(orderId);
    }

    public List<Order> findByOrderId(Integer orderId) {
        return orderDAORepository.findByOrderId(orderId);
    }

    public static void main(String... args) {
        OrderService orderService = new OrderService(new OrderDAORepositoryImpl());

        Order order1 = Order.builder()
                .orderNumber(10426)
                .orderDate("2020-06-19")
                .requiredDate("2020-06-19")
                .shippedDate("2020-06-19")
                .status("In Process")
                .build();

        orderService.create(order1);

        orderService.findByOrderId(10426)
                .forEach(order -> System.out.println("order = " + order));

        orderService.delete(10426);
    }
}
