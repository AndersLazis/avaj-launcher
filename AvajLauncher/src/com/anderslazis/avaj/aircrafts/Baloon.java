package com.anderslazis.avaj.aircrafts;

public class Baloon extends Aircraft
{
	public Baloon (long p_id, String p_name, Coordinates p_coordinate){
		super(p_id, p_name, p_coordinate);
		//super.registerTower(super.weatherTower);
	}
	public void updateConditions(){};

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

}