package com.iphrends.drools.models;

import lombok.Data;

@Data
public class IdCard implements Pojo {
    private int age;
    private String location;
	private boolean issueCard;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isIssueCard() {
		return issueCard;
	}

	public void setIssueCard(boolean issueCard) {
		this.issueCard = issueCard;
	}
}
