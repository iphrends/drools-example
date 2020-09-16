package com.iphrends.drools.services;

import org.kie.api.runtime.KieContainer;

public abstract class BaseDroolsService<T> {

    protected final KieContainer kieContainer;

    protected BaseDroolsService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public abstract T execute(T object);

}
