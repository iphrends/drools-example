package com.iphrends.drools.services;

import com.iphrends.drools.config.TrackingAgendaEventListener;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

@Slf4j
public abstract class BaseDroolsService {

    private final KieContainer kieContainer;

    protected BaseDroolsService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    protected <T> T execute(T object) {
        KieSession kieSession = kieContainer.newKieSession();
        AgendaEventListener agendaEventListener = new TrackingAgendaEventListener();
        kieSession.addEventListener(agendaEventListener);
        try {
            log.info("{} inserting...", object);
            kieSession.insert(object);
            log.info("{} rules fired...!!!", kieSession.fireAllRules());
        } finally {
            kieSession.dispose();
            log.info("session disposed...!!!");
        }
        return object;
    }
}
