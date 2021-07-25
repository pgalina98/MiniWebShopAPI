package org.kingict.miniwebshop.controller;

import org.kingict.miniwebshop.dto.ProductDTO;
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
    public ProductDTO getSingleProduct(@PathVariable("productId") Long productId) {
        return productFacade.getProductById(productId);
    }

    //GET All Products
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productFacade.getAllProducts();
    }
}
