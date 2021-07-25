package org.kingict.miniwebshop.mapper.implementation;

import org.kingict.miniwebshop.dto.OrderProductDTO;
import org.kingict.miniwebshop.dto.ProductDTO;
import org.kingict.miniwebshop.entity.Order;
import org.kingict.miniwebshop.entity.Product;
import org.kingict.miniwebshop.mapper.OrderDTOMapper;
import org.kingict.miniwebshop.mapper.OrderProductDTOMapper;
import org.kingict.miniwebshop.repository.OrderProductRepository;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class OrderProductDTOMapperImplementation implements OrderProductDTOMapper {

    private final OrderProductRepository orderProductRepository;

    public OrderProductDTOMapperImplementation(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public OrderProductDTO map(Order order, Product product) {
        return Optional.ofNullable(product).map(p -> {
            OrderProductDTO orderProductDTO = new OrderProductDTO();

            orderProductDTO.setId(p.getId());
            orderProductDTO.setBrand(p.getBrand());
            orderProductDTO.setNaziv(p.getNaziv());
            orderProductDTO.setOpis(p.getOpis());
            orderProductDTO.setCijena(p.getCijena());
            orderProductDTO.setDostupnaKolicina(p.getDostupnaKolicina());
            orderProductDTO.setNarucenaKolicina(getOrderedProductQuantity(order.getId(), p.getId()));

            return orderProductDTO;
        }).orElse(null);
    }

    @Override
    public List<OrderProductDTO> map(Order order, List<Product> products) {
        return products.stream()
                       .map(p -> {
           OrderProductDTO orderProductDTO = new OrderProductDTO();

           orderProductDTO.setId(p.getId());
           orderProductDTO.setBrand(p.getBrand());
           orderProductDTO.setNaziv(p.getNaziv());
           orderProductDTO.setOpis(p.getOpis());
           orderProductDTO.setCijena(p.getCijena());
           orderProductDTO.setDostupnaKolicina(p.getDostupnaKolicina());
           orderProductDTO.setNarucenaKolicina(getOrderedProductQuantity(order.getId(), p.getId()));

           return orderProductDTO;
        }).collect(Collectors.toList());
    }

    private Integer getOrderedProductQuantity(Long orderId, Long productId) {
        return orderProductRepository.findByNarudzbaIdAndProizvodId(orderId, productId)
                                     .getKolicina();
    }
}
