package com.siit.homework.course15.spring_data_jdbc.service;

import com.siit.homework.course15.spring_data_jdbc.entity.Product;
import com.siit.homework.course15.spring_data_jdbc.repository.ProductDAORepository;
import com.siit.homework.course15.spring_data_jdbc.repository.ProductDAORepositoryImpl;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
public class ProductService {
    private final ProductDAORepository productDAORepository;

    public void create(Product product) {
        productDAORepository.save(product);
    }

    public void delete(String productCode) {
        productDAORepository.delete(productCode);
    }

    public List<Product> findByProductCode(String productCode) {
        return productDAORepository.findByOrderId(productCode);
    }

    public void update(Product product) {
        productDAORepository.update(product);
    }

    public static void main(String... args) {
        ProductService productService = new ProductService(new ProductDAORepositoryImpl());

        Product product1 = Product.builder()
                .productCode("S72_3213")
                .productName("2001 Ferrari Enzo")
                .productLine("Classic Cars")
                .productScale("1:10")
                .productVendor("Classic Metal Creations")
                .productDescription("2001 Ferrari Enzo")
                .quantityInStock(500)
                .buyPrice(new BigDecimal(250))
                .msrp(new BigDecimal(326))
                .build();

        productService.create(product1);

        productService.findByProductCode("S72_3213")
                .forEach(product -> System.out.println("product = " + product));

        product1.setBuyPrice(new BigDecimal(300));
        product1.setMsrp(new BigDecimal(370));

        productService.update(product1);
        System.out.println("===========Update===========");
        productService.findByProductCode("S72_3213")
                .forEach(product -> System.out.println("product = " + product));

        productService.delete("S72_3213");
    }
}
