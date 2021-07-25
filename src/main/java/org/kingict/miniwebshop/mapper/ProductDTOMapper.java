package org.kingict.miniwebshop.mapper;

import org.kingict.miniwebshop.dto.ProductDTO;
import org.kingict.miniwebshop.entity.Product;

import java.util.List;

public interface ProductDTOMapper {

    ProductDTO map(Product product);
    List<ProductDTO> map(List<Product> products);
}
