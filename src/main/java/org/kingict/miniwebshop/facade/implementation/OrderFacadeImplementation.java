package org.kingict.miniwebshop.facade.implementation;

import org.kingict.miniwebshop.entity.Order;
import org.kingict.miniwebshop.entity.Product;
import org.kingict.miniwebshop.facade.OrderFacade;
import org.kingict.miniwebshop.form.OrderForm;
import org.kingict.miniwebshop.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFacadeImplementation implements OrderFacade {

    private final OrderService orderService;

    public OrderFacadeImplementation(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @Override
    public Order createNewOrder(OrderForm orderForm) {
        Order order = new Order();

        BeanUtils.copyProperties(orderForm, order);

        return orderService.createNewOrder(order);
    }

    @Override
    public Order updateOrderById(Long orderId, OrderForm updatedOrder) {
        Order order = orderService.getOrderById(orderId);

        BeanUtils.copyProperties(updatedOrder, order);
        return orderService.updateOrderById(order);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderService.deleteOrderById(orderId);
    }

    @Override
    public Order addProductsOfOrder(Long orderId, List<Product> products) {
        Order order = orderService.getOrderById(orderId);
        order.getOrderProducts().addAll(products);

        return orderService.addProductsOfOrder(order);
    }
}
