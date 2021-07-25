package org.kingict.miniwebshop.mapper;

import org.kingict.miniwebshop.dto.DiscountCodeDTO;
import org.kingict.miniwebshop.dto.OrderDTO;
import org.kingict.miniwebshop.entity.DiscountCode;
import org.kingict.miniwebshop.entity.Order;

import java.util.List;

public interface DiscountCodeDTOMapper {

    DiscountCodeDTO map(DiscountCode discountCode);
    List<DiscountCodeDTO> map(List<DiscountCode> discountCodes);
}
