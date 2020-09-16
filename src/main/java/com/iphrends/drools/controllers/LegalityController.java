package com.iphrends.drools.controllers;

import com.iphrends.drools.models.Legality;
import com.iphrends.drools.services.BaseDroolsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/legality")
public class LegalityController extends BaseController {

    protected LegalityController(@Qualifier("legalityService") BaseDroolsService<Legality> baseDroolsService) {
        super(baseDroolsService);
    }

    @GetMapping("/{legalityType}")
    public Legality execute(@PathVariable final String legalityType) {
        return execute(createLegality(legalityType));
    }

    private Legality createLegality(final String legalityType) {
        return new Legality(legalityType);
    }
}
