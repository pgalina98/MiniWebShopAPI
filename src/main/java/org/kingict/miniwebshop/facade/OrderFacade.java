package org.kingict.miniwebshop.facade;

import org.kingict.miniwebshop.dto.OrderDTO;
import org.kingict.miniwebshop.entity.Order;

import java.util.List;

public interface OrderFacade {

    OrderDTO getOrderById(Long orderId);
    List<OrderDTO> getAllOrders();
    void createNewOrder(Order order);
    void updateOrderById(Long orderId, Order updatedOrder);
    void deleteOrderById(Long orderId);
}
