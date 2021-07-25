package org.kingict.miniwebshop.mapper;

import org.kingict.miniwebshop.dto.OrderProductDTO;
import org.kingict.miniwebshop.entity.Order;
import org.kingict.miniwebshop.entity.Product;

import java.util.List;

public interface OrderProductDTOMapper {

    OrderProductDTO map(Order order, Product product);
    List<OrderProductDTO> map(Order order, List<Product> products);
}
