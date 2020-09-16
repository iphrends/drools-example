package com.iphrends.drools.services;

import com.iphrends.drools.config.TrackingAgendaEventListener;
import com.iphrends.drools.models.FireAlarm;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FireAlarmService extends BaseDroolsService<FireAlarm> {

    protected FireAlarmService(KieContainer kieContainer) {
        super(kieContainer);
    }

    @Override
    public FireAlarm execute(FireAlarm object) {

        final KieSession kieSession = getKieContainer().newKieSession();
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
