package com.iphrends.drools.models;

import lombok.Data;

@Data
public class Order implements Pojo {

    private String name;
    private long price;
    private int discount;
    private String cardType;
}
