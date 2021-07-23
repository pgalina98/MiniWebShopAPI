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
        return orderRepository.findAll();
    }

    @Override
    public void createNewOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void updateOrderById(Order updatedOrder) {
        orderRepository.save(updatedOrder);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
