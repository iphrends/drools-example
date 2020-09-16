package com.iphrends.drools.models;

import lombok.Data;

@Data
public class Alarm implements Pojo {

    private boolean on;

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}
}
