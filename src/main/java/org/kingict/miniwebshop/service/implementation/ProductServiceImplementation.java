package org.kingict.miniwebshop.service.implementation;

import org.kingict.miniwebshop.entity.Product;
import org.kingict.miniwebshop.repository.ProductRepository;
import org.kingict.miniwebshop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findProductById(productId);
    }

    @Override
    public Product updateProduct(Product updatedProduct) {
        return (Product) productRepository.save(updatedProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createNewProduct(Product product) {
        return (Product) productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }
}
