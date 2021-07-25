package org.kingict.miniwebshop.mapper.implementation;

import org.kingict.miniwebshop.dto.BrandDTO;
import org.kingict.miniwebshop.entity.Brand;
import org.kingict.miniwebshop.mapper.BrandDTOMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BrandDTOMapperImplementation implements BrandDTOMapper {
    @Override
    public BrandDTO map(Brand brand) {
        return Optional.ofNullable(brand).map(b -> {
            BrandDTO brandDTO = new BrandDTO();

            brandDTO.setId(b.getId());
            brandDTO.setNaziv(b.getNaziv());

            return brandDTO;
        }).orElse(null);
    }

    @Override
    public List<BrandDTO> map(List<Brand> brands) {
        return brands.stream()
                     .map(brand -> map(brand)).collect(Collectors.toList());
    }
}
