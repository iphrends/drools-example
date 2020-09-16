package com.iphrends.drools.controllers;

import com.iphrends.drools.models.Fine;
import com.iphrends.drools.services.BaseDroolsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fines")
public class FineController extends BaseController {

    public FineController(@Qualifier("fineService") BaseDroolsService<Fine> baseDroolsService) {
        super(baseDroolsService);
    }

    @PostMapping("/vehicles")
    public Fine getFine(@RequestBody Fine fine) {
        return execute(fine);
    }
}
