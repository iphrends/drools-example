package com.iphrends.drools.models;

import lombok.Data;

@Data
public class FireAlarm implements Pojo {
    private Room room;
    private Sprinkler sprinkler;
    private Fire fire;
	private Alarm alarm;

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Sprinkler getSprinkler() {
		return sprinkler;
	}

	public void setSprinkler(Sprinkler sprinkler) {
		this.sprinkler = sprinkler;
	}

	public Fire getFire() {
		return fire;
	}

	public void setFire(Fire fire) {
		this.fire = fire;
	}

	public Alarm getAlarm() {
		return alarm;
	}

	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
	}
}
