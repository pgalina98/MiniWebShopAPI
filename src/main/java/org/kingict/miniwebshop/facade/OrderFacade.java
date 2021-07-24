package org.kingict.miniwebshop.facade;

import org.kingict.miniwebshop.entity.Order;
import org.kingict.miniwebshop.entity.Product;
import org.kingict.miniwebshop.form.OrderForm;

import java.util.List;

public interface OrderFacade {

    Order getOrderById(Long orderId);
    List<Order> getAllOrders();
    Order createNewOrder(OrderForm orderForm);
    Order updateOrderById(Long orderId, OrderForm updatedOrder);
    void deleteOrderById(Long orderId);
    Order addProductsOfOrder(Long orderId, List<Product> products);
    List<Product> getAllProductsOfOrder(Long orderId);
    Order removeProductFromOrder(Long orderId, Long productId);
}
