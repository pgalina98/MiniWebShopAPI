package org.kingict.miniwebshop.mapper;

import org.kingict.miniwebshop.dto.BrandDTO;
import org.kingict.miniwebshop.entity.Brand;

import java.util.List;

public interface BrandDTOMapper {

    BrandDTO map(Brand brand);
    List<BrandDTO> map(List<Brand> brands);
}
