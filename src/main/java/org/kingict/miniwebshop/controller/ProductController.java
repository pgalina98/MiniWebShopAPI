package org.kingict.miniwebshop.controller;

import org.kingict.miniwebshop.dto.ProductDTO;
import org.kingict.miniwebshop.facade.ProductFacade;
import org.kingict.miniwebshop.form.ProductForm;
import org.springframework.web.bind.annotation.*;

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

    //POST New Product
    @PostMapping
    public ProductDTO createNewProduct(@RequestBody ProductForm productForm) {
        return productFacade.createNewProduct(productForm);
    }
}
