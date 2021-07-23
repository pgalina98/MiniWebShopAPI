package org.kingict.miniwebshop.facade.implementation;

import org.kingict.miniwebshop.dto.OrderDTO;
import org.kingict.miniwebshop.entity.Order;
import org.kingict.miniwebshop.facade.OrderFacade;
import org.kingict.miniwebshop.mapper.OrderDTOMapper;
import org.kingict.miniwebshop.service.OrderService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFacadeImplementation implements OrderFacade {

    private final OrderService orderService;
    private final OrderDTOMapper orderDTOMapper;

    public OrderFacadeImplementation(OrderService orderService, OrderDTOMapper orderDTOMapper) {
        this.orderService = orderService;
        this.orderDTOMapper = orderDTOMapper;
    }

    @Override
    public OrderDTO getOrderById(Long orderId) {
        return orderDTOMapper.map(orderService.getOrderById(orderId));
    }

    @Override
    public List<OrderDTO> getAllOrders() {
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
