package com.iphrends.drools.models;

import lombok.Data;

@Data
public class IdCard implements Pojo {
    private int age;
    private String location;
    private boolean issueCard;
}
