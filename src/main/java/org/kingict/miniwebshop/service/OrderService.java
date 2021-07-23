package org.kingict.miniwebshop.service;

import org.kingict.miniwebshop.entity.Order;
import org.kingict.miniwebshop.form.OrderForm;

import java.util.List;

public interface OrderService {

    Order getOrderById(Long orderId);
    List<Order> getAllOrders();
    void createNewOrder(Order order);
    void updateOrderById(Order updatedOrder);
    void deleteOrderById(Long orderId);
}
