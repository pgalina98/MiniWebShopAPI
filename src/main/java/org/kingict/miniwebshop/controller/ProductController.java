package org.kingict.miniwebshop.controller;

import org.kingict.miniwebshop.dto.ProductDTO;
import org.kingict.miniwebshop.entity.Product;
import org.kingict.miniwebshop.facade.ProductFacade;
import org.kingict.miniwebshop.form.ProductForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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

    //DELETE Product
    @DeleteMapping("/{productId}")
    public ResponseEntity deleteProductById(@PathVariable("productId") Long productId) {
        ProductDTO product = productFacade.getProductById(productId);

        if(Objects.isNull(product)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        productFacade.deleteProductById(productId);

        return new ResponseEntity(product, HttpStatus.OK);
    }

    //PUT Product
    @PutMapping("/{productId}")
    public ResponseEntity updateOrderById(@PathVariable("productId") Long productId,
                                          @RequestBody ProductForm updatedProductForm) {
        ProductDTO product = productFacade.getProductById(productId);

        if(Objects.isNull(product)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(productFacade.updateProductById(productId, updatedProductForm),
                                  HttpStatus.OK);
    }
}
