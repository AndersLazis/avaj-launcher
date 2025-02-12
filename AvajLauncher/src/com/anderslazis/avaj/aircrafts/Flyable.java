package com.anderslazis.avaj.aircrafts;
import com.anderslazis.avaj.tower.WeatherTower;

public abstract class Flyable {

	protected WeatherTower weatherTower;

	public abstract String getType();
	public abstract String getName();
	public abstract Long getId();

	public abstract void updateConditions();
	public void registerTower(WeatherTower p_tower){
		this.weatherTower = p_tower;
		weatherTower.register(this);
	};

}
