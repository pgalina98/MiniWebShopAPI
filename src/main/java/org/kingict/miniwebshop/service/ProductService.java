package org.kingict.miniwebshop.service;

import org.kingict.miniwebshop.entity.Product;

public interface ProductService {

    Product getProductById(Long productId);
    Product updateProduct(Product updatedProduct);
}
