package com.iphrends.drools.services;

import com.iphrends.drools.config.TrackingAgendaEventListener;
import com.iphrends.drools.models.Order;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService extends BaseDroolsService<Order> {

	private static final Logger log = LoggerFactory.getLogger(OrderService.class);

	public OrderService(KieContainer kieContainer) {
		super(kieContainer);
	}

	private final KieSession kieSession = getKieContainer().newKieSessionsPool(2).newKieSession();

	@Override
	public Order execute(Order object) {
		AgendaEventListener agendaEventListener = new TrackingAgendaEventListener();
		kieSession.addEventListener(agendaEventListener);
		try {
			log.info("{} inserting...", object);
			kieSession.insert(object);
//			kieSession.getAgenda().getAgendaGroup("ag2").setFocus();
			kieSession.getAgenda().getAgendaGroup("ag1").setFocus();
			log.info("{} rules fired...!!!", kieSession.fireAllRules());
			kieSession.getAgenda().clear();
		} finally {
//            kieSession.dispose();
//            log.info("session disposed...!!!");
		}
		return object;
	}

	public Order getDiscount(Order order) {
		return execute(order);
	}

}
