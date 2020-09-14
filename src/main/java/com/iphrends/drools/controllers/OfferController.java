package com.iphrends.drools.controllers;

import com.iphrends.drools.models.Order;
import com.iphrends.drools.services.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OfferController {
    private final OrderService orderService;

    public OfferController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/discount")
    public Order getDiscount(@RequestBody Order order) {
        return orderService.getDiscount(order);
    }
}
