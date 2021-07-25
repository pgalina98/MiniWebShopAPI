package org.kingict.miniwebshop.facade.implementation;

import org.kingict.miniwebshop.dto.ProductDTO;
import org.kingict.miniwebshop.entity.Product;
import org.kingict.miniwebshop.facade.ProductFacade;
import org.kingict.miniwebshop.mapper.ProductDTOMapper;
import org.kingict.miniwebshop.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductFacadeImplementation implements ProductFacade {

    private final ProductService productService;
    private final ProductDTOMapper productDTOMapper;

    public ProductFacadeImplementation(ProductService productService, ProductDTOMapper productDTOMapper) {
        this.productService = productService;
        this.productDTOMapper = productDTOMapper;
    }

    @Override
    public ProductDTO getProductById(Long productId) {
        return productDTOMapper.map(productService.getProductById(productId));
    }

    @Override
    public Product updateProductById(Long productId, Product updatedProduct) {
        Product product = productService.getProductById(productId);

        BeanUtils.copyProperties(updatedProduct, product);
        return productService.updateProduct(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productDTOMapper.map(productService.getAllProducts());
    }
}
