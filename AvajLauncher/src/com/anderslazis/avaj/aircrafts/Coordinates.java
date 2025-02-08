package com.anderslazis.avaj.aircrafts;

public class Coordinates{
	private int longitude;
	private int latitute;
	private int height;

	Coordinates(int p_longitude, int p_latitude, int p_height){
		this.longitude = p_longitude;
		this.latitute = p_latitude;
		this.height = p_height;
	}

	public int  getLongitude(){
		return longitude;
	}

	public int getHeight() {
		return height;
	}

	public int getLatitute() {
		return latitute;
	}
}