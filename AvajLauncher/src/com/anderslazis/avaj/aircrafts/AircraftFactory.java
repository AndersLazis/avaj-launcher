package com.anderslazis.avaj.aircrafts;


public class AircraftFactory {

	private static AircraftFactory instance;

	private AircraftFactory(){};

	public static synchronized AircraftFactory getInstance() {
		if (instance == null)
		{
			instance = new AircraftFactory();
		}
		return instance;
	}

	long p_id = 0;
	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates){
		switch (p_type){
			case "Baloon":
				return new Baloon((p_id+1), p_name, p_coordinates);
//			case "Helicopter":
//				return new Baloon((p_id+1), p_name, p_coordinates);
//			case "JetPlane":
//				return new Baloon((p_id+1), p_name, p_coordinates);
			default:
				throw new IllegalArgumentException("Error: unknown type of aircraft: " + p_type);
		}


	}
}
