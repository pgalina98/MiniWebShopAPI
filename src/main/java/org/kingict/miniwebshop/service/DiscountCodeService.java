package org.kingict.miniwebshop.service;

import org.kingict.miniwebshop.dto.DiscountCodeDTO;
import org.kingict.miniwebshop.entity.DiscountCode;
import org.kingict.miniwebshop.form.DiscountCodeForm;
import org.kingict.miniwebshop.form.OrderForm;

import java.util.List;

public interface DiscountCodeService {

    DiscountCode getDiscountCodeById(Long discountCodeId);
    List<DiscountCode> getAllDiscountCodes();
    DiscountCode createNewDiscountCode(DiscountCode discountCode);
    DiscountCode updateDiscountCodeById(DiscountCode updatedDiscountCode);
    void deleteDiscountCodeById(Long discountCodeId);
}
