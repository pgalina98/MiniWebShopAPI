package org.kingict.miniwebshop.mapper;

import org.kingict.miniwebshop.dto.OrderDTO;
import org.kingict.miniwebshop.entity.Order;

public interface OrderMapper {

    OrderDTO map(Order order);
}
