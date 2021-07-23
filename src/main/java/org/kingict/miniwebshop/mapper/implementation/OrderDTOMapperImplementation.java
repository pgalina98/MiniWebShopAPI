package org.kingict.miniwebshop.mapper.implementation;

import org.kingict.miniwebshop.dto.OrderDTO;
import org.kingict.miniwebshop.entity.Order;
import org.kingict.miniwebshop.mapper.OrderDTOMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderDTOMapperImplementation implements OrderDTOMapper {

    @Override
    public OrderDTO map(Order order) {
        Order test = order;

        return Optional.ofNullable(order).map(o -> {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setUkupnaCijenaBezPopusta(o.getUkupnaCijenaBezPopusta());
            orderDTO.setUkupnaCijenaSPopustom(o.getUkupnaCijenaSPopustom());
            orderDTO.setDatumNarudzbe(o.getDatumNarudzbe());
            orderDTO.setBrojKartice(o.getBrojKartice());
            orderDTO.setEmail(o.getEmail());
            orderDTO.setBrojMobitela(o.getBrojMobitela());
            orderDTO.setAdresaDostave(o.getAdresaDostave());
            orderDTO.setNapomena(o.getNapomena());

            return orderDTO;
        }).orElse(null);
    }
}
