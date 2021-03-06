package com.iphrends.drools.services;

import com.iphrends.drools.config.TrackingAgendaEventListener;
import com.iphrends.drools.models.IdCard;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IdCardService extends BaseDroolsService<IdCard> {
	
	private static final Logger log = LoggerFactory.getLogger(IdCardService.class);

    protected IdCardService(KieContainer kieContainer) {
        super(kieContainer);
    }

    @Override
    public IdCard execute(IdCard object) {
        KieSession kieSession = kieContainer.newKieSession();
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

    public IdCard getIdCard(IdCard card) {
        return execute(card);
    }
}
