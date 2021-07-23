package org.kingict.miniwebshop.controller;

import org.kingict.miniwebshop.dto.OrderDTO;
import org.kingict.miniwebshop.entity.Order;
import org.kingict.miniwebshop.facade.OrderFacade;
import org.kingict.miniwebshop.form.OrderForm;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderFacade orderFacade;

    public OrderController(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
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

    //Get All Orders
    @GetMapping()
    public List<OrderDTO> getAllOrders() {
        return orderFacade.getAllOrders();
    }

    //POST New Order
    @PostMapping
    public void createNewOrder(@RequestBody OrderForm orderForm) {
        orderFacade.createNewOrder(orderForm);
    }

    //PUT Order -> TODO
    @PutMapping("/{orderId}")
    public ResponseEntity updateOrderById(@PathVariable("orderId") Long orderId,
                                          @RequestBody OrderForm updatedOrderForm) {
        OrderDTO order = orderFacade.getOrderById(orderId);

        if(Objects.isNull(order)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        orderFacade.updateOrderById(orderId, updatedOrderForm);

        return null;
    }

    //DELETE Order
    @DeleteMapping("/{orderId}")
    public ResponseEntity deleteOrderById(@PathVariable("orderId") Long orderId) {
        OrderDTO order = orderFacade.getOrderById(orderId);

        if(Objects.isNull(order)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        orderFacade.deleteOrderById(orderId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
