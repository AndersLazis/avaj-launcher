package com.anderslazis.avaj.simulator;
import com.anderslazis.avaj.aircrafts.Flyable;
import com.anderslazis.avaj.aircrafts.Baloon;

public class AircraftFactory {
	long p_id = 0;
	Flyable* newAircraft(string p_type, string p_name, Coordinates p_coordinates){

		switch (p_type){
			case "Baloon":
				return new Balloon((p_id+1), p_name, p_coordinates);
		}


	}
}


//class AircraftFactory <<Singleton>>
//		{
//		+Flyable* newAircraft(string p_type, string p_name, Coordinates p_coordinates)
//}