package com.iphrends.drools.controllers;

import com.iphrends.drools.models.Fine;
import com.iphrends.drools.services.FineService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fines")
public class FineController {

    private final FineService fineService;

    public FineController(FineService fineService) {
        this.fineService = fineService;
    }

    @PostMapping("/vehicles")
    public Fine getFine(@RequestBody Fine fine) {
        return fineService.getFine(fine);
    }
}
