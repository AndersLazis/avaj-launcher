package com.anderslazis.avaj.aircrafts;

/**
 * The Helicopter class represents a type of aircraft that reacts to different weather conditions.
 * It extends the Aircraft class and implements behavior specific to helicopters.
 */
public class Helicopter extends Aircraft
{

	public Helicopter(long p_id, String p_name, Coordinates p_coordinate){
		super(p_id, p_name, p_coordinate);
		//super.registerTower(super.weatherTower);
	}

	/**
	 * Updates the helicopter's conditions based on the current weather.
	 * Modifies the coordinates accordingly and prints a message describing the effect.
	 */
	public void updateConditions() {
		String currentWeather = weatherTower.getWeather(this.coordinates);
		switch (currentWeather)  {
			case "SUN":
				/* SUN - Longitude increases with 10, Height increases with 2 */
				this.coordinates = new Coordinates(coordinates.getLongitude()+10,
						coordinates.getLatitude(),coordinates.getHeight()+2);
				System.out.println("Helicopter" + "#" + this.name + "(" + this.id +
						"): This is hot.");
				break;
			case "RAIN":
				/* RAIN - Longitude increases with 5 */
				this.coordinates = new Coordinates(coordinates.getLongitude() + 5,
						coordinates.getLatitude(),coordinates.getHeight());
				System.out.println("Helicopter" + "#" + this.name + "(" + this.id +
						"): Damn rain! Heli don't like rains!");
				break;
			case "FOG":
				/* FOG - Longitude increases with 1 */
				this.coordinates = new Coordinates(coordinates.getLongitude() + 1,
						coordinates.getLatitude(),coordinates.getHeight());
				System.out.println("Helicopter" + "#" + this.name + "(" + this.id +
						"): Damn fog! It's dangerous to flight on Heli in mountains!");
				break;
			case "SNOW":
				/* Height decreases with 12 */
				this.coordinates = new Coordinates(coordinates.getLongitude(),
						coordinates.getLatitude(),coordinates.getHeight() - 12);
				System.out.println("Helicopter" + "#" + this.name + "(" + this.id +
						"): My rotor is going to freeze!");
				break;
		}
		if (this.coordinates.getHeight() <=0)
			System.out.println("Helicopter" + "#" + this.name + "(" + this.id + "): landing.");
	};

	/**
	 * Set of getters.
	 */
	@Override
	public final String getType(){
		return "Helicopter";
	}

	@Override
	public final String getName(){
		return super.name;
	}

	@Override
	public final Long getId(){
		return super.id;
	}

	@Override
	public final int getHeight(){
		return this.coordinates.getHeight();
	}

}