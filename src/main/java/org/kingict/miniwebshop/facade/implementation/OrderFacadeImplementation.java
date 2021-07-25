package org.kingict.miniwebshop.facade.implementation;

import org.kingict.miniwebshop.dto.OrderDTO;
import org.kingict.miniwebshop.dto.OrderProductDTO;
import org.kingict.miniwebshop.dto.ProductDTO;
import org.kingict.miniwebshop.entity.Order;
import org.kingict.miniwebshop.entity.OrderProduct;
import org.kingict.miniwebshop.entity.Product;
import org.kingict.miniwebshop.facade.OrderFacade;
import org.kingict.miniwebshop.form.OrderForm;
import org.kingict.miniwebshop.mapper.OrderDTOMapper;
import org.kingict.miniwebshop.mapper.OrderProductDTOMapper;
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
    private final OrderDTOMapper orderDTOMapper;
    private final OrderProductDTOMapper orderProductDTOMapper;

    public OrderFacadeImplementation(OrderService orderService, ProductService productService, OrderProductService orderProductService, OrderDTOMapper orderDTOMapper, OrderProductDTOMapper orderProductDTOMapper) {
        this.orderService = orderService;
        this.productService = productService;
        this.orderProductService = orderProductService;
        this.orderDTOMapper = orderDTOMapper;
        this.orderProductDTOMapper = orderProductDTOMapper;
    }

    @Override
    public OrderDTO getOrderById(Long orderId) {
        return orderDTOMapper.map(orderService.getOrderById(orderId));
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderDTOMapper.map(orderService.getAllOrders());
    }

    @Override
    public OrderDTO createNewOrder(OrderForm orderForm) {
        Order order = new Order();

        BeanUtils.copyProperties(orderForm, order);

        return orderDTOMapper.map(orderService.createNewOrder(order));
    }

    @Override
    public OrderDTO updateOrderById(Long orderId, OrderForm updatedOrder) {
        Order order = orderService.getOrderById(orderId);

        BeanUtils.copyProperties(updatedOrder, order);

        return orderDTOMapper.map(orderService.updateOrder(order));
    }

    @Override
    public void deleteOrderById(Long orderId) {
        orderService.deleteOrderById(orderId);
    }

    @Override
    public OrderDTO addProductsOfOrder(Long orderId, List<Product> products) {
        Order order = orderService.getOrderById(orderId);

        products.forEach(product -> {
            updateProductsOfOrder(orderId, product);
        });
        updateQuantityOfProducts(products);

        return orderDTOMapper.map(orderService.addProductsOfOrder(order));
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
    public List<OrderProductDTO> getAllProductsOfOrder(Long orderId) {
        Order order = orderService.getOrderById(orderId);
        List<Product> products = order.getProductsOfOrder();

        return orderProductDTOMapper.map(order, products);
    }
}
