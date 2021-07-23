package org.kingict.miniwebshop.facade.implementation;

import org.kingict.miniwebshop.dto.OrderDTO;
import org.kingict.miniwebshop.entity.Order;
import org.kingict.miniwebshop.facade.OrderFacade;
import org.kingict.miniwebshop.form.OrderForm;
import org.kingict.miniwebshop.mapper.OrderMapper;
import org.kingict.miniwebshop.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderFacadeImplementation implements OrderFacade {

    private final OrderService orderService;
    private final OrderMapper orderDTOMapper;

    public OrderFacadeImplementation(OrderService orderService, OrderMapper orderDTOMapper) {
        this.orderService = orderService;
        this.orderDTOMapper = orderDTOMapper;
    }

    @Override
    public OrderDTO getOrderById(Long orderId) {
        return orderDTOMapper.map(orderService.getOrderById(orderId));
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders()
                           .stream()
                           .map(order -> orderDTOMapper.map(order))
                           .collect(Collectors.toList());
    }

    @Override
    public void createNewOrder(OrderForm orderForm) {
        Order order = new Order();

        BeanUtils.copyProperties(orderForm, order);

        orderService.createNewOrder(order);
    }

    @Override
    public void updateOrderById(Long orderId, Order updatedOrder) {

    }

    @Override
    public void deleteOrderById(Long orderId) {

    }
}
