package com.siit.homework.course15.spring_data_jdbc.repository;

import com.siit.homework.course15.spring_data_jdbc.entity.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderDAORepositoryImpl implements OrderDAORepository {

    private PreparedStatement getPreparedStatement(String query) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?serverTimezone=EET",
                    "root",
                    "password");
            return connection.prepareStatement(query);
        } catch (SQLException throwable) {
            System.out.println("Error while getting connection");
            throw new RuntimeException("Error while getting connection", throwable);
        }
    }

    @Override
    public void save(Order order) {
        String query = "INSERT INTO orders(orderNumber, orderDate, requiredDate, status, comments, customerNumber) VALUES (?,?, ?,?,?, ?)";
        PreparedStatement preparedStatement = getPreparedStatement(query);

        int rowsAffected = 0;
        try {
            preparedStatement.setInt(1, order.getOrderNumber());
            preparedStatement.setDate(2, Date.valueOf(order.getOrderDate()));
            preparedStatement.setDate(3, Date.valueOf(order.getRequiredDate()));
//            preparedStatement.setDate(4, Date.valueOf(order.getShippedDate()));
            preparedStatement.setString(4, order.getStatus());
            preparedStatement.setString(5, order.getComments());
            preparedStatement.setInt(6, order.getCustomerNumber());
            rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Eror while inserting order!");
            throw new RuntimeException(e);
        }

        if (rowsAffected > 0) {
            System.out.println("Order " + order + " was inserted successfuly!");
        }
    }

    @Override
    public List<Order> findByOrderId(int orderId) {
        String query = "select * " +
                "from orders o " +
                "where o.orderNumber = ?";

        PreparedStatement ps = getPreparedStatement(query);
        List<Order> orders = new ArrayList<>();

        try {
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = extractOrderFromResultSet(rs);
                orders.add(order);
            }

        } catch (SQLException e) {
            System.out.println("Error while retrieving orders with orderId: " + orderId);
            throw new RuntimeException(e);
        }

        return orders;
    }

    private Order extractOrderFromResultSet(ResultSet rs) throws SQLException {
        return Order.builder()
                .orderNumber(rs.getInt("orderNumber"))
                .orderDate(rs.getString("orderDate"))
                .requiredDate(rs.getString("requiredDate"))
                .shippedDate(rs.getString("shippedDate"))
                .status(rs.getString("status"))
                .comments(rs.getString("comments"))
                .customerNumber(rs.getInt("customerNumber"))
                .build();
    }

    @Override
    public void update(Order order) {
        PreparedStatement preparedStatement = getPreparedStatement(
                "UPDATE orders SET " +
                        "status = ?," +
                        "comments =? " +
                        "WHERE orderNumber = ?");
        int rowsAffected = 0;

        try {
            preparedStatement.setString(1, order.getStatus());
            preparedStatement.setString(2, order.getComments());
            preparedStatement.setInt(3, order.getOrderNumber());

            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eror while updating orders!");
            throw new RuntimeException(e);
        }

        if (rowsAffected > 0) {
            System.out.println("Order with id " + order.getOrderNumber() + " was updated successfuly!");
        }
    }

    @Override
    public void delete(int orderId) {
        PreparedStatement preparedStatement = getPreparedStatement("DELETE FROM orders WHERE orderNumber = ?");
        int rowsAffected = 0;

        try {
            preparedStatement.setInt(1, orderId);

            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eror while deleting order!");
            throw new RuntimeException(e);
        }

        if (rowsAffected > 0) {
            System.out.println("Order with id " + orderId + " was deleted successfuly!");
        }
    }
}
