package org.kingict.miniwebshop.service.implementation;

import org.kingict.miniwebshop.entity.OrderProduct;
import org.kingict.miniwebshop.repository.OrderProductRepository;
import org.kingict.miniwebshop.service.OrderProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductServiceImplementation implements OrderProductService {

    private final OrderProductRepository orderProductRepository;

    public OrderProductServiceImplementation(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public OrderProduct createNewOrderProduct(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }

}
