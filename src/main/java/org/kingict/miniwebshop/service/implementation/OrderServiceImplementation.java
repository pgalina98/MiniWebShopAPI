package org.kingict.miniwebshop.service.implementation;

import org.kingict.miniwebshop.entity.Order;
import org.kingict.miniwebshop.entity.Product;
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
    public Order createNewOrder(Order order) {
        return (Order) orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order updatedOrder) {
        return (Order) orderRepository.save(updatedOrder);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public Order addProductsOfOrder(Order order) {
        return (Order) orderRepository.save(order);
    }

    @Override
    public List<Product> getAllProductsOfOrder(Long orderId) {
        Order order = orderRepository.findOrderById(orderId);

        return order.getOrderProducts();
    }

    @Override
    public Order removeProductFromOrder(Order order) {
        return (Order) orderRepository.save(order);
    }
}
