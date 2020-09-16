package com.iphrends.drools.controllers;

import com.iphrends.drools.models.Pojo;
import com.iphrends.drools.services.BaseDroolsService;

public abstract class BaseController {

    private final BaseDroolsService baseDroolsService;

    protected BaseController(BaseDroolsService baseDroolsService) {
        this.baseDroolsService = baseDroolsService;
    }

    public <T extends Pojo> T execute(T object) {
        return (T) baseDroolsService.execute(object);
    }
}
