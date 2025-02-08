package com.anderslazis.avaj.simulator;
import com.anderslazis.avaj.aircrafts.Coordinates;
import com.anderslazis.avaj.aircrafts.Flyable;
import com.anderslazis.avaj.aircrafts.Baloon;


public class AircraftFactory {

	private static AircraftFactory instance;

	private AircraftFactory(){};
	public static AircraftFactory getInstance() {
		if (instance == null)
		{
			instance = new AircraftFactory();
		}
		return instance;
	}

	long p_id = 0;
	public Flyable* newAircraft(String p_type, String p_name, Coordinates p_coordinates){
		switch (p_type){
			case "Baloon":
				return new Baloon((p_id+1), p_name, p_coordinates);
//			case "Helicopter":
//				return new Baloon((p_id+1), p_name, p_coordinates);
//			case "JetPlane":
//				return new Baloon((p_id+1), p_name, p_coordinates);
			default:
				return null;
		}


	}
}
