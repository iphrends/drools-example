package com.iphrends.drools.models;

import lombok.Data;

@Data
public class FireAlarm implements Pojo {
    private Room room;
    private Sprinkler sprinkler;
    private Fire fire;
    private Alarm alarm;
}
