package com.iphrends.drools.services;

import com.iphrends.drools.config.TrackingAgendaEventListener;
import com.iphrends.drools.models.Fine;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FineService extends BaseDroolsService<Fine> {

    protected FineService(KieContainer kieContainer) {
        super(kieContainer);
    }

    @Override
    public Fine execute(Fine object) {
        KieSession kieSession = getKieContainer().newKieSession();
        AgendaEventListener agendaEventListener = new TrackingAgendaEventListener();
        kieSession.addEventListener(agendaEventListener);
        try {
            log.info("{} inserting...", object);
            kieSession.insert(object);
            kieSession.getAgenda().getAgendaGroup("ag2").setFocus();
            kieSession.getAgenda().getAgendaGroup("ag1").setFocus();
            log.info("{} rules fired...!!!", kieSession.fireAllRules());
        } finally {
            kieSession.dispose();
            log.info("session disposed...!!!");
        }
        return object;
    }

    public Fine getFine(Fine fine) {
        return execute(fine);
    }
}
