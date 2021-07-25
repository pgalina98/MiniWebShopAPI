package org.kingict.miniwebshop.service.implementation;

import org.kingict.miniwebshop.entity.DiscountCode;
import org.kingict.miniwebshop.repository.DiscountCodeRepository;
import org.kingict.miniwebshop.service.DiscountCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCodeServiceImplementation implements DiscountCodeService {

    private final DiscountCodeRepository discountCodeRepository;

    public DiscountCodeServiceImplementation(DiscountCodeRepository discountCodeRepository) {
        this.discountCodeRepository = discountCodeRepository;
    }

    @Override
    public DiscountCode getDiscountCodeById(Long discountCodeId) {
        return discountCodeRepository.findDiscountCodeById(discountCodeId);
    }

    @Override
    public List<DiscountCode> getAllDiscountCodes() {
        return discountCodeRepository.findAll();
    }

    @Override
    public DiscountCode createNewDiscountCode(DiscountCode discountCode) {
        return null;
    }

    @Override
    public DiscountCode updateDiscountCodeById(DiscountCode updatedDiscountCode) {
        return null;
    }

    @Override
    public void deleteDiscountCodeById(Long discountCodeId) {

    }
}
