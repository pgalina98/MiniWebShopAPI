package org.kingict.miniwebshop.facade;

import org.kingict.miniwebshop.dto.DiscountCodeDTO;
import org.kingict.miniwebshop.dto.OrderDTO;
import org.kingict.miniwebshop.form.DiscountCodeForm;
import org.kingict.miniwebshop.form.OrderForm;

import java.util.List;

public interface DiscountCodeFacade {

    DiscountCodeDTO getDiscountCodeById(Long discountCodeId);
    List<DiscountCodeDTO> getAllDiscountCodes();
    DiscountCodeDTO createNewDiscountCode(DiscountCodeForm discountCodeForm);
    DiscountCodeDTO updateDiscountCodeById(Long discountCodeId, OrderForm updatedDiscountCode);
    void deleteDiscountCodeById(Long discountCodeId);
}
