package com.iphrends.drools.models;

import java.util.List;

public class Role {

    private String name;
    private List<String> memberTypes;
    private int min;
    private int max;
    private List<Nationality> nationalities;

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }

    public Role(String name, List<String> memberTypes, int min, int max, List<Nationality> nationalities) {
        this.name = name;
        this.memberTypes = memberTypes;
        this.min = min;
        this.max = max;
        this.nationalities = nationalities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMemberTypes() {
        return memberTypes;
    }

    public void setMemberTypes(List<String> memberTypes) {
        this.memberTypes = memberTypes;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public List<Nationality> getNationalities() {
        return nationalities;
    }

    public void setNationalities(List<Nationality> nationalities) {
        this.nationalities = nationalities;
    }
}
