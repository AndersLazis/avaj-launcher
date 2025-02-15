package com.anderslazis.avaj.aircrafts;

/**
 * The JetPlane class represents a type of aircraft that reacts to different weather conditions.
 * It extends the Aircraft class and implements behavior specific to jetPlanes.
 */
public class JetPlane extends Aircraft
{

	public JetPlane(long p_id, String p_name, Coordinates p_coordinate){
		super(p_id, p_name, p_coordinate);
		//super.registerTower(super.weatherTower);
	}

	/**
	 * Updates the jetPlane's conditions based on the current weather.
	 * Modifies the coordinates accordingly and prints a message describing the effect.
	 */
	public void updateConditions() {
		String currentWeather = weatherTower.getWeather(this.coordinates);
		switch (currentWeather)  {
			case "SUN":
				/* SUN - Latitude increases with 10, Height increases with 2 */
				this.coordinates = new Coordinates(coordinates.getLongitude(),
						coordinates.getLatitude() + 10,coordinates.getHeight()+2);
				System.out.println("JetPlane" + "#" + this.name + "(" + this.id +
						"): Sunny day. Let's flight!");
				break;
			case "RAIN":
				/* RAIN - Latitude increases with 5 */
				this.coordinates = new Coordinates(coordinates.getLongitude(),
						coordinates.getLatitude() + 5,coordinates.getHeight());
				System.out.println("JetPlane" + "#" + this.name + "(" + this.id +
						"): It's raining. Better watch out for lightings.");
				break;
			case "FOG":
				/* Latitude increases with 1 */
				this.coordinates = new Coordinates(coordinates.getLongitude(),
						coordinates.getLatitude() + 1,coordinates.getHeight());
				System.out.println("JetPlane" + "#" + this.name + "(" + this.id +
						"): Damn fog! Turn on windshield heating.");
				break;
			case "SNOW":
				/* SNOW - Height decreases with 7 */
				this.coordinates = new Coordinates(coordinates.getLongitude(),
						coordinates.getLatitude(),coordinates.getHeight()-7);
				System.out.println("JetPlane" + "#" + this.name + "(" + this.id +
						"): OMG! Winter is coming!");
				break;
		}
		if (this.coordinates.getHeight() <=0)
			System.out.println("JetPlane" + "#" + this.name + "(" + this.id + "): landing.");
	};

	/**
	 * Set of getters.
	 */
	@Override
	public final String getType(){
		return "JetPlane";
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