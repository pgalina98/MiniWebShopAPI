package org.kingict.miniwebshop.facade.implementation;

import org.kingict.miniwebshop.dto.DiscountCodeDTO;
import org.kingict.miniwebshop.facade.DiscountCodeFacade;
import org.kingict.miniwebshop.form.DiscountCodeForm;
import org.kingict.miniwebshop.form.OrderForm;
import org.kingict.miniwebshop.mapper.DiscountCodeDTOMapper;
import org.kingict.miniwebshop.service.DiscountCodeService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DiscountCodeFacadeImplementation implements DiscountCodeFacade {

    private final DiscountCodeService discountCodeService;
    private final DiscountCodeDTOMapper discountCodeDTOMapper;

    public DiscountCodeFacadeImplementation(DiscountCodeService discountCodeService, DiscountCodeDTOMapper discountCodeDTOMapper) {
        this.discountCodeService = discountCodeService;
        this.discountCodeDTOMapper = discountCodeDTOMapper;
    }

    @Override
    public DiscountCodeDTO getDiscountCodeById(Long discountCodeId) {
        return discountCodeDTOMapper.map(discountCodeService.getDiscountCodeById(discountCodeId));
    }

    @Override
    public List<DiscountCodeDTO> getAllDiscountCodes() {
        return discountCodeDTOMapper.map(discountCodeService.getAllDiscountCodes());
    }

    @Override
    public DiscountCodeDTO createNewDiscountCode(DiscountCodeForm discountCodeForm) {
        return null;
    }

    @Override
    public DiscountCodeDTO updateDiscountCodeById(Long discountCodeId, OrderForm updatedDiscountCode) {
        return null;
    }

    @Override
    public void deleteDiscountCodeById(Long discountCodeId) {

    }
}
