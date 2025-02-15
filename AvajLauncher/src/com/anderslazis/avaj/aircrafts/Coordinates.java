package com.anderslazis.avaj.aircrafts;

public class Coordinates{
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int p_longitude, int p_latitude, int p_height){
		if (p_longitude < 0) {
			this.longitude = 0;
		} else if (p_longitude > 360) {
			this.longitude = 360;
		} else {
			this.longitude = p_longitude;
		}

		if (p_latitude < 0) {
			this.latitude = 0;
		} else if (p_latitude > 360) {
			this.latitude = 360;
		} else {
			this.latitude = p_latitude;
		}

		if (p_height < 0) {
			this.height = 0;
		} else if (p_height > 100) {
			this.height = 100;
		} else {
			this.height = p_height;
		}
	}

	public int  getLongitude(){
		return longitude;
	}

	public int getHeight() {
		return height;
	}

	public int getLatitude() {
		return latitude;
	}

	public static Coordinates create (int p_longitude, int p_latitude, int p_height){
		return new Coordinates(p_longitude, p_latitude, p_height);
	}
}