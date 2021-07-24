package org.kingict.miniwebshop.repository;

import org.kingict.miniwebshop.entity.Product;

import java.util.List;

public interface ProductCustomRepository {

    List<Product> findProductsOfOrderById(Long orderId);
}
