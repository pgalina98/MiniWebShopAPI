package org.kingict.miniwebshop.facade.implementation;

import org.kingict.miniwebshop.entity.Product;
import org.kingict.miniwebshop.facade.ProductFacade;
import org.kingict.miniwebshop.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductFacadeImplementation implements ProductFacade {

    private final ProductService productService;

    public ProductFacadeImplementation(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Product getProductById(Long productId) {
        return productService.getProductById(productId);
    }

    @Override
    public Product updateProductById(Long productId, Product updatedProduct) {
        Product product = productService.getProductById(productId);

        BeanUtils.copyProperties(updatedProduct, product);
        return productService.updateProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
