package org.kingict.miniwebshop.mapper.implementation;

import org.kingict.miniwebshop.dto.BrandDTO;
import org.kingict.miniwebshop.dto.DiscountCodeDTO;
import org.kingict.miniwebshop.entity.DiscountCode;
import org.kingict.miniwebshop.mapper.DiscountCodeDTOMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DiscountCodeMapperImplementation implements DiscountCodeDTOMapper {

    @Override
    public DiscountCodeDTO map(DiscountCode discountCode) {
        return Optional.ofNullable(discountCode).map(dc -> {
            DiscountCodeDTO discountCodeDTO = new DiscountCodeDTO();

            discountCodeDTO.setId(dc.getId());
            discountCodeDTO.setKod(dc.getKod());
            discountCodeDTO.setPopust(dc.getPopust());
            discountCodeDTO.setIskoristen(dc.isIskoristen());
            discountCodeDTO.setDatumKreiranja(dc.getDatumKreiranja());

            return discountCodeDTO;
        }).orElse(null);
    }

    @Override
    public List<DiscountCodeDTO> map(List<DiscountCode> discountCodes) {
        return discountCodes.stream()
                            .map(discountCode -> map(discountCode)).collect(Collectors.toList());
    }
}
