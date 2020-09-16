package com.iphrends.drools.models;

import lombok.Data;

@Data
public class Sprinkler implements Pojo {

    private boolean on;

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}
}
