package org.kingict.miniwebshop.service.implementation;

import org.kingict.miniwebshop.entity.Order;
import org.kingict.miniwebshop.repository.OrderRepository;
import org.kingict.miniwebshop.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImplementation(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findOrderById(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public void createNewOrder(Order order) {

    }

    @Override
    public void updateOrderById(Long orderId, Order updatedOrder) {

    }

    @Override
    public void deleteOrderById(Long orderId) {

    }
}
