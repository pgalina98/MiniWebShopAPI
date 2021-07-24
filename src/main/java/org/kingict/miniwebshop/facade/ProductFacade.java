package org.kingict.miniwebshop.facade;

import org.kingict.miniwebshop.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductFacade {

    Product getProductById(Long productId);
    Product updateProductById(Long productId, Product product);
    List<Product> getAllProducts();
}
