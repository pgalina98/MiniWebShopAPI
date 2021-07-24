package org.kingict.miniwebshop.facade.implementation;

import org.kingict.miniwebshop.entity.Order;
import org.kingict.miniwebshop.entity.OrderProduct;
import org.kingict.miniwebshop.entity.Product;
import org.kingict.miniwebshop.facade.OrderFacade;
import org.kingict.miniwebshop.form.OrderForm;
import org.kingict.miniwebshop.service.OrderProductService;
import org.kingict.miniwebshop.service.OrderService;
import org.kingict.miniwebshop.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFacadeImplementation implements OrderFacade {

    private final OrderService orderService;
    private final ProductService productService;
    private final OrderProductService orderProductService;

    public OrderFacadeImplementation(OrderService orderService, ProductService productService, OrderProductService orderProductService) {
        this.orderService = orderService;
        this.productService = productService;
        this.orderProductService = orderProductService;
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
        return orderService.updateOrder(order);
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderService.deleteOrderById(orderId);
    }

    @Override
    public Order addProductsOfOrder(Long orderId, List<Product> products) {
        Order order = orderService.getOrderById(orderId);

        products.forEach(product -> {
            updateProductsOfOrder(orderId, product);
        });
        updateQuantityOfProducts(products);

        return orderService.addProductsOfOrder(order);
    }

    private void updateProductsOfOrder(Long orderId, Product product) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setNarudzbaId(orderId);
        orderProduct.setProizvodId(product.getId());
        orderProduct.setKolicina(product.getDostupnaKolicina());

        orderProductService.createNewOrderProduct(orderProduct);
    }

    private void updateQuantityOfProducts(List<Product> orderedProducts) {
        orderedProducts.forEach(product -> {
            Product updatedProduct = productService.getProductById(product.getId());
            updatedProduct.setDostupnaKolicina(updatedProduct.getDostupnaKolicina() - product.getDostupnaKolicina());

            productService.updateProduct(updatedProduct);
        });
    }

    @Override
    public List<Product> getAllProductsOfOrder(Long orderId) {
        List<Product> products = productService.getOrderProducts(orderId);

        return products;
    }

    @Override
    public Order removeProductFromOrder(Long orderId, Long productId) {
        Order order = orderService.getOrderById(orderId);
        order.getOrderProducts().removeIf(product -> product.getId().equals(productId));

        return orderService.removeProductFromOrder(order);
    }
}
