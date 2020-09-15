package com.iphrends.drools.services;

import org.kie.api.runtime.KieContainer;

public abstract class BaseDroolsService<T> {

    private final KieContainer kieContainer;

    public KieContainer getKieContainer() {
        return kieContainer;
    }

    protected BaseDroolsService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public abstract T execute(T object);

}
