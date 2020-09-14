package com.iphrends.drools.services;

import com.iphrends.drools.models.Order;
import org.kie.api.runtime.KieContainer;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseDroolsService {

    public OrderService(KieContainer kieContainer) {
        super(kieContainer);
    }

    public Order getDiscount(Order order) {
        return execute(order);
    }

}
