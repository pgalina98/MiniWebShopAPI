package org.kingict.miniwebshop.facade;

import org.kingict.miniwebshop.dto.ProductDTO;
import org.kingict.miniwebshop.entity.Product;
import org.kingict.miniwebshop.form.ProductForm;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductFacade {

    ProductDTO getProductById(Long productId);
    Product updateProductById(Long productId, Product product);
    List<ProductDTO> getAllProducts();
    ProductDTO createNewProduct(ProductForm productForm);
    ProductDTO updateProductById(Long productId, ProductForm updatedProduct);
    void deleteProductById(Long productId);
}
