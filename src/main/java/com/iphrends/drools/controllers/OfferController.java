package com.iphrends.drools.controllers;

import com.iphrends.drools.models.Order;
import com.iphrends.drools.services.BaseDroolsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OfferController extends BaseController {

    public OfferController(@Qualifier("orderService") BaseDroolsService<Order> orderService) {
        super(orderService);
    }

    @PostMapping("/discount")
    public Order getDiscount(@RequestBody Order order) {
        return execute(order);
    }
}
