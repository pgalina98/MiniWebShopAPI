package org.kingict.miniwebshop.controller;

import org.kingict.miniwebshop.dto.OrderDTO;
import org.kingict.miniwebshop.facade.OrderFacade;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private List<OrderDTO> getAllOrders() {
        return orderFacade.getAllOrders();
    }

    //POST New Order

    //PUT Order

    //DELETE Order
}
