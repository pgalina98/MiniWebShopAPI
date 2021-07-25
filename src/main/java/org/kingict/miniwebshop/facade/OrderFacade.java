package org.kingict.miniwebshop.facade;

import org.kingict.miniwebshop.dto.OrderDTO;
import org.kingict.miniwebshop.dto.OrderProductDTO;
import org.kingict.miniwebshop.dto.ProductDTO;
import org.kingict.miniwebshop.entity.Product;
import org.kingict.miniwebshop.form.OrderForm;

import java.util.List;

public interface OrderFacade {

    OrderDTO getOrderById(Long orderId);
    List<OrderDTO> getAllOrders();
    OrderDTO createNewOrder(OrderForm orderForm);
    OrderDTO updateOrderById(Long orderId, OrderForm updatedOrder);
    void deleteOrderById(Long orderId);
    OrderDTO addProductsOfOrder(Long orderId, List<Product> products);
    List<OrderProductDTO> getAllProductsOfOrder(Long orderId);
}
