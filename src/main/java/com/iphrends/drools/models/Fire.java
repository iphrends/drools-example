package com.iphrends.drools.models;

import lombok.Data;

@Data
public class Fire implements Pojo {
	private Room room;

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
}
