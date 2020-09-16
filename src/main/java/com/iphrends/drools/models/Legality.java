package com.iphrends.drools.models;

import java.util.List;

public class Legality implements Pojo {

    private String legalityType;
    private List<Role> roles;
    private List<String> activitiesType;

    public Legality(String legalityType) {
        this.legalityType = legalityType;
    }

    public Legality() {
    }

    public List<String> getActivitiesType() {
        return activitiesType;
    }

    public void setActivitiesType(List<String> activitiesType) {
        this.activitiesType = activitiesType;
    }

    public String getLegalityType() {
        return legalityType;
    }

    public void setLegalityType(String legalityType) {
        this.legalityType = legalityType;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
