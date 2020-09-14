package com.iphrends.drools.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public abstract class BaseDroolsService {

    private final KieContainer kieContainer;

    protected BaseDroolsService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    protected <T> T execute(T object) {
        KieSession kieSession = kieContainer.newKieSession();
        try {
            kieSession.insert(object);
            kieSession.fireAllRules();
        } finally {
            kieSession.dispose();
        }
        return object;
    }
}
