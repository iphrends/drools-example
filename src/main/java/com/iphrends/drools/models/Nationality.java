package com.iphrends.drools.models;

import org.apache.commons.collections4.keyvalue.DefaultKeyValue;

import java.util.List;

public class Nationality {
    private List<String> combinations;
    private String remark;
    private List<DefaultKeyValue<String, String>> attributes;
    private List<String> activitiesType;

    public Nationality() {
    }

    public Nationality(List<String> combinations, String remark, List<DefaultKeyValue<String, String>> attributes, List<String> activitiesType) {
        this.combinations = combinations;
        this.remark = remark;
        this.attributes = attributes;
        this.activitiesType = activitiesType;
    }

    public List<String> getActivitiesType() {
        return activitiesType;
    }

    public void setActivitiesType(List<String> activitiesType) {
        this.activitiesType = activitiesType;
    }

    public List<String> getCombinations() {
        return combinations;
    }

    public void setCombinations(List<String> combinations) {
        this.combinations = combinations;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<DefaultKeyValue<String, String>> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<DefaultKeyValue<String, String>> attributes) {
        this.attributes = attributes;
    }
}
