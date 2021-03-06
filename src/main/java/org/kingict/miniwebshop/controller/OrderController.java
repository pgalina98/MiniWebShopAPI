package org.kingict.miniwebshop.controller;

import org.kingict.miniwebshop.dto.OrderDTO;
import org.kingict.miniwebshop.dto.ProductDTO;
import org.kingict.miniwebshop.entity.Product;
import org.kingict.miniwebshop.facade.OrderFacade;
import org.kingict.miniwebshop.facade.ProductFacade;
import org.kingict.miniwebshop.form.OrderForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderFacade orderFacade;
    private final ProductFacade productFacade;

    public OrderController(OrderFacade orderFacade, ProductFacade productFacade) {
        this.orderFacade = orderFacade;
        this.productFacade = productFacade;
    }

    //GET Single Order
    @GetMapping("/{orderId}")
    public ResponseEntity getSingleOrderById(@PathVariable("orderId") Long orderId) {
        OrderDTO order = orderFacade.getOrderById(orderId);

        if(Objects.isNull(order)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(order, HttpStatus.OK);
    }

    //GET All Orders
    @GetMapping()
    public List<OrderDTO> getAllOrders() {
        return orderFacade.getAllOrders();
    }

    //POST New Order
    @PostMapping
    public OrderDTO createNewOrder(@RequestBody OrderForm orderForm) {
        return orderFacade.createNewOrder(orderForm);
    }

    //PUT Order
    @PutMapping("/{orderId}")
    public ResponseEntity updateOrderById(@PathVariable("orderId") Long orderId,
                                          @RequestBody OrderForm updatedOrderForm) {
        OrderDTO order = orderFacade.getOrderById(orderId);

        if(Objects.isNull(order)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(orderFacade.updateOrderById(orderId, updatedOrderForm),
                                  HttpStatus.OK);
    }

    //DELETE Order
    @DeleteMapping("/{orderId}")
    public ResponseEntity deleteOrderById(@PathVariable("orderId") Long orderId) {
        OrderDTO order = orderFacade.getOrderById(orderId);

        if(Objects.isNull(order)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        orderFacade.deleteOrderById(orderId);

        return new ResponseEntity(order, HttpStatus.OK);
    }

    //GET All Order Products
    @GetMapping("/{orderId}/products")
    public ResponseEntity getAllProductsOfOrder(@PathVariable("orderId") Long orderId) {
        OrderDTO order = orderFacade.getOrderById(orderId);

        if(Objects.isNull(order)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(orderFacade.getAllProductsOfOrder(orderId),
                                  HttpStatus.OK);
    }

    //POST Orders Products
    @PostMapping("/{orderId}/products")
    public ResponseEntity addProductsOfCreatedOrder(@PathVariable("orderId") Long orderId,
                                                    @RequestBody List<Product> products) {
        OrderDTO order = orderFacade.getOrderById(orderId);

        if(Objects.isNull(order)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(orderFacade.addProductsOfOrder(orderId, products),
                                  HttpStatus.OK);
    }
}
