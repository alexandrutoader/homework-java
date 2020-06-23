package com.siit.homework.course15.spring_data_jdbc.repository;

import com.siit.homework.course15.spring_data_jdbc.entity.Order;
import com.siit.homework.course15.spring_data_jdbc.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAORepositoryImpl implements ProductDAORepository {
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
    public void save(Product product) {
        String query = "INSERT INTO products(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = getPreparedStatement(query);

        int rowsAffected = 0;
        try {
            preparedStatement.setString(1, product.getProductCode());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setString(3, product.getProductLine());
            preparedStatement.setString(4, product.getProductScale());
            preparedStatement.setString(5, product.getProductVendor());
            preparedStatement.setString(6, product.getProductDescription());
            preparedStatement.setInt(7, product.getQuantityInStock());
            preparedStatement.setBigDecimal(8, product.getBuyPrice());
            preparedStatement.setBigDecimal(9, product.getMsrp());
            rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Eror while inserting order!");
            throw new RuntimeException(e);
        }

        if (rowsAffected > 0) {
            System.out.println("Order " + product + " was inserted successfuly!");
        }
    }

    @Override
    public List<Product> findByOrderId(String productCode) {
        String query = "select * " +
                "from products p " +
                "where p.productCode = ?";

        PreparedStatement ps = getPreparedStatement(query);
        List<Product> products = new ArrayList<>();

        try {
            ps.setString(1, productCode);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = extractOrderFromResultSet(rs);
                products.add(product);
            }

        } catch (SQLException e) {
            System.out.println("Error while retrieving orders with orderId: " + productCode);
            throw new RuntimeException(e);
        }

        return products;
    }

    private Product extractOrderFromResultSet(ResultSet rs) throws SQLException {
        return Product.builder()
                .productCode(rs.getString("productCode"))
                .productName(rs.getString("productName"))
                .productLine(rs.getString("productLine"))
                .productScale(rs.getString("productScale"))
                .productVendor(rs.getString("productVendor"))
                .productDescription(rs.getString("productDescription"))
                .quantityInStock(rs.getInt("quantityInStock"))
                .buyPrice(rs.getBigDecimal("buyPrice"))
                .msrp(rs.getBigDecimal("msrp"))
                .build();
    }

    @Override
    public void update(Product product) {
        PreparedStatement preparedStatement = getPreparedStatement(
                "UPDATE products SET " +
                        "buyPrice = ? " +
                        "WHERE productCode = ?");
        int rowsAffected = 0;

        try {
            preparedStatement.setBigDecimal(1, product.getBuyPrice());
            preparedStatement.setString(2, product.getProductCode());

            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eror while updating orders!");
            throw new RuntimeException(e);
        }

        if (rowsAffected > 0) {
            System.out.println("Order with id " + product.getProductCode() + " was updated successfuly!");
        }
    }

    @Override
    public void delete(String productCode) {
        PreparedStatement preparedStatement = getPreparedStatement("DELETE FROM products WHERE productCode = ?");
        int rowsAffected = 0;

        try {
            preparedStatement.setString(1, productCode);

            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eror while deleting order!");
            throw new RuntimeException(e);
        }

        if (rowsAffected > 0) {
            System.out.println("Product with id " + productCode + " was deleted successfuly!");
        }
    }
}
