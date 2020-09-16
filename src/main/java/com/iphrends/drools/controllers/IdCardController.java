package com.iphrends.drools.controllers;

import com.iphrends.drools.models.IdCard;
import com.iphrends.drools.services.IdCardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/id-cards")
public class IdCardController {

    private final IdCardService idCardService;

    public IdCardController(IdCardService idCardService) {
        this.idCardService = idCardService;
    }

    @PostMapping
    public IdCard getFine(@RequestBody IdCard idCard) {
        return idCardService.getIdCard(idCard);
    }
}
