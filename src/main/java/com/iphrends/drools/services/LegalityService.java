package com.iphrends.drools.services;

import com.iphrends.drools.config.TrackingAgendaEventListener;
import com.iphrends.drools.models.Legality;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LegalityService extends BaseDroolsService<Legality> {

    private static final Logger log = LoggerFactory.getLogger(LegalityService.class);

    protected LegalityService(KieContainer kieContainer) {
        super(kieContainer);
    }

    @Override
    public Legality execute(Legality object) {
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
