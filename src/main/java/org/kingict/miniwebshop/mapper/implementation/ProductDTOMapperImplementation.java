package org.kingict.miniwebshop.mapper.implementation;

import org.kingict.miniwebshop.dto.ProductDTO;
import org.kingict.miniwebshop.entity.Product;
import org.kingict.miniwebshop.mapper.ProductDTOMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductDTOMapperImplementation implements ProductDTOMapper {

    @Override
    public ProductDTO map(Product product) {
        return Optional.ofNullable(product).map(p -> {
            ProductDTO productDTO = new ProductDTO();

            productDTO.setId(p.getId());
            productDTO.setBrand(p.getBrand());
            productDTO.setNaziv(p.getNaziv());
            productDTO.setOpis(p.getOpis());
            productDTO.setCijena(p.getCijena());
            productDTO.setDostupnaKolicina(p.getDostupnaKolicina());

            return productDTO;
        }).orElse(null);
    }

    @Override
    public List<ProductDTO> map(List<Product> products) {
        return products.stream()
                       .map(p -> map(p))
                       .collect(Collectors.toList());
    }
}
