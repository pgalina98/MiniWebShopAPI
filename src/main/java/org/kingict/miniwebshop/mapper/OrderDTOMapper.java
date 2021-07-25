package org.kingict.miniwebshop.mapper;

import org.kingict.miniwebshop.dto.OrderDTO;
import org.kingict.miniwebshop.entity.Order;

import java.util.List;

public interface OrderDTOMapper {

    OrderDTO map(Order order);
    List<OrderDTO> map(List<Order> orders);
}
