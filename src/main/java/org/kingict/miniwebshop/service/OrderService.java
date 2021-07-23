package org.kingict.miniwebshop.service;

import org.kingict.miniwebshop.entity.Order;

import java.util.List;

public interface OrderService {

    Order getOrderById(Long orderId);
    List<Order> getAllOrders();
    void createNewOrder(Order order);
    void updateOrderById(Long orderId, Order updatedOrder);
    void deleteOrderById(Long orderId);
}
