package com.iphrends.drools.controllers;

import com.iphrends.drools.models.FireAlarm;
import com.iphrends.drools.services.BaseDroolsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fire-alarm")
public class FireAlarmController extends BaseController {

    public FireAlarmController(@Qualifier("fireAlarmService") BaseDroolsService<FireAlarm> baseDroolsService) {
        super(baseDroolsService);
    }

    @PostMapping("/on")
    public FireAlarm fireAlarmOn(@RequestBody FireAlarm fireAlarm) {
        fireAlarm.getAlarm().setOn(true);
        return execute(fireAlarm);
    }

    @PostMapping("/off")
    public FireAlarm fireAlarmOff(@RequestBody FireAlarm fireAlarm) {
        fireAlarm.getAlarm().setOn(false);
        return execute(fireAlarm);
    }
}
