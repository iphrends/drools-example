package com.iphrends.drools.services;

import com.iphrends.drools.models.Fine;
import org.kie.api.runtime.KieContainer;
import org.springframework.stereotype.Service;

@Service
public class FineService extends BaseDroolsService {

    protected FineService(KieContainer kieContainer) {
        super(kieContainer);
    }

    public Fine getFine(Fine fine) {
        return execute(fine);
    }
}
