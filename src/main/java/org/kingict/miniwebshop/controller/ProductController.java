package org.kingict.miniwebshop.controller;

import org.kingict.miniwebshop.entity.Product;
import org.kingict.miniwebshop.facade.ProductFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductFacade productFacade;

    public ProductController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    //GET Single Product
    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId") Long productId) {
        return productFacade.getProductById(productId);
    }

    //GET All Products
    @GetMapping
    public List<Product> getAllProducts() {
        return productFacade.getAllProducts();
    }
}
