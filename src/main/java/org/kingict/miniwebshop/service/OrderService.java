package org.kingict.miniwebshop.service;

import org.kingict.miniwebshop.entity.Order;
import org.kingict.miniwebshop.entity.Product;
import org.kingict.miniwebshop.form.OrderForm;

import java.util.List;

public interface OrderService {

    Order getOrderById(Long orderId);
    List<Order> getAllOrders();
    Order createNewOrder(Order order);
    Order updateOrderById(Order updatedOrder);
    void deleteOrderById(Long orderId);
    Order addProductsOfOrder(Order order);
    List<Product> getAllProductsOfOrder(Long orderId);
}
