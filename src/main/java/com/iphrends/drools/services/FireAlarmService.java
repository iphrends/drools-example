package com.iphrends.drools.services;

import com.iphrends.drools.config.TrackingAgendaEventListener;
import com.iphrends.drools.models.FireAlarm;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FireAlarmService extends BaseDroolsService<FireAlarm> {
	
	private static final Logger log = LoggerFactory.getLogger(FireAlarmService.class);

    protected FireAlarmService(KieContainer kieContainer) {
        super(kieContainer);
    }

    @Override
    public FireAlarm execute(FireAlarm object) {

        final KieSession kieSession = kieContainer.newKieSession();
        kieSession.addEventListener(new TrackingAgendaEventListener());
        try {
            log.info("{} inserting...", object);
            kieSession.insert(object.getAlarm());
            kieSession.insert(object.getSprinkler());
            kieSession.insert(object.getRoom());
            kieSession.insert(object.getFire());
            log.info("{} rules fired...!!!", kieSession.fireAllRules());

        } finally {
            kieSession.dispose();
            log.info("session disposed...!!!");
        }
        return object;
    }

    public FireAlarm getFireAlarm(FireAlarm fireAlarm) {
        return execute(fireAlarm);
    }
}
