package com.anderslazis.avaj.aircrafts;

public abstract class Aircraft extends Flyable {

	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate){
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinate;
	}

	/* Debug methods. They shouldn't be used during simulation */
	public int getHeight() {return this.coordinates.getHeight();}
	public int getLongtitude() {return this.coordinates.getLongitude();}
	public int getLatitude() {return this.coordinates.getLatitude();}
	public Coordinates getCoordinates(){return this.coordinates;}


}
