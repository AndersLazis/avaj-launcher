package com.anderslazis.avaj.aircrafts;

/**
 * The Baloon class represents a type of aircraft that reacts to different weather conditions.
 * It extends the Aircraft class and implements behavior specific to balloons.
 */
public class Baloon extends Aircraft
{

	public Baloon (long p_id, String p_name, Coordinates p_coordinate){
		super(p_id, p_name, p_coordinate);
		//super.registerTower(super.weatherTower);
	}

	/**
	 * Updates the balloon's conditions based on the current weather.
	 * Modifies the coordinates accordingly and prints a message describing the effect.
	 */
	public void updateConditions() {
		String currentWeather = weatherTower.getWeather(this.coordinates);
		switch (currentWeather)  {
			case "SUN":
				/*SUN - Longitude increases with 2, Height increases with 4*/
				this.coordinates = new Coordinates(coordinates.getLongitude()+2,
						coordinates.getLatitude(),coordinates.getHeight()+4);
				System.out.println("Balloon" + "#" + this.name + "(" + this.id +
						"): Let's enjoy the good weather and take some pics.");
				break;
			case "RAIN":
				/*◦ RAIN - Height decreases with 5*/
				this.coordinates = new Coordinates(coordinates.getLongitude(),
						coordinates.getLatitude(),coordinates.getHeight()-4);
				System.out.println("Balloon" + "#" + this.name + "(" + this.id +
						"): : Damn you rain! You messed up my baloon.");
			case "FOG":
				/*◦ FOG - Height decreases with 3*/
				this.coordinates = new Coordinates(coordinates.getLongitude(),
						coordinates.getLatitude(),coordinates.getHeight()-3);
				System.out.println("Balloon" + "#" + this.name + "(" + this.id +
						"): Damn you fog! I can't see anything.");
				break;
			case "SNOW":
				/*◦ SNOW - Height decreases with 15*/
				this.coordinates = new Coordinates(coordinates.getLongitude(),
						coordinates.getLatitude(),coordinates.getHeight()-15);
				System.out.println("Balloon" + "#" + this.name + "(" + this.id +
						"): It's snowing. We're gonna crash.");
				break;
		}
		if (this.coordinates.getHeight() <=0){
			System.out.println("Balloon" + "#" + this.name + "(" + this.id + "): landing.");
		}
	};

	/**
	 * Set of getters.
	 */
	@Override
	public final String getType(){
		return "Baloon";
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