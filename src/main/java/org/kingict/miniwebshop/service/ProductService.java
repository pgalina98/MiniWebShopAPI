package org.kingict.miniwebshop.service;

import org.kingict.miniwebshop.entity.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(Long productId);
    Product updateProduct(Product updatedProduct);
    List<Product> getAllProducts();
    Product createNewProduct(Product product);
    void deleteProductById(Long productId);
}
