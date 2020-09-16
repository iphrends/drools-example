package com.iphrends.drools.models;

import lombok.Data;

@Data
public class Fine implements Pojo {

    private int speed;
    private String vehicle;
    private int fine;
}
