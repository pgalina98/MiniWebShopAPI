package org.kingict.miniwebshop.mapper.implementation;

import org.kingict.miniwebshop.dto.OrderDTO;
import org.kingict.miniwebshop.entity.Order;
import org.kingict.miniwebshop.mapper.OrderDTOMapper;
import org.kingict.miniwebshop.mapper.OrderProductDTOMapper;
import org.kingict.miniwebshop.mapper.ProductDTOMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrderDTOMapperImplementation implements OrderDTOMapper {

    private final ProductDTOMapper productDTOMapper;
    private final OrderProductDTOMapper orderProductDTOMapper;

    public OrderDTOMapperImplementation(ProductDTOMapper productDTOMapper, OrderProductDTOMapper orderProductDTOMapper) {
        this.productDTOMapper = productDTOMapper;
        this.orderProductDTOMapper = orderProductDTOMapper;
    }

    @Override
    public OrderDTO map(Order order) {
        return Optional.ofNullable(order).map(o -> {
            OrderDTO orderDTO = new OrderDTO();

            orderDTO.setId(o.getId());
            orderDTO.setDiscountCode(o.getDiscountCode());
            orderDTO.setPaymentMethod(o.getPaymentMethod());
            orderDTO.setOrderProducts(Objects.isNull(o.getOrderProducts())
                                                    ? new ArrayList<>()
                                                    : orderProductDTOMapper.map(o, o.getProductsOfOrder()));
            orderDTO.setUkupnaCijenaBezPopusta(o.getUkupnaCijenaBezPopusta());
            orderDTO.setUkupnaCijenaSPopustom(o.getUkupnaCijenaSPopustom());
            orderDTO.setDatumKreiranjaNarudzbe(o.getDatumKreiranjaNarudzbe());
            orderDTO.setDatumAzuriranjaNarudzbe(o.getDatumAzuriranjaNarudzbe());
            orderDTO.setBrojKartice(o.getBrojKartice());
            orderDTO.setEmail(o.getEmail());
            orderDTO.setBrojMobitela(o.getBrojMobitela());
            orderDTO.setAdresaDostave(o.getAdresaDostave());
            orderDTO.setNapomena(o.getNapomena());

            return orderDTO;
        }).orElse(null);
    }

    @Override
    public List<OrderDTO> map(List<Order> orders) {
        return orders.stream()
                     .map(order -> map(order)).collect(Collectors.toList());
    }
}
