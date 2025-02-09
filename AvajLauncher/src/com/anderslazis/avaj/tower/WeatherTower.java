package com.anderslazis.avaj.tower;
import com.anderslazis.avaj.aircrafts.Coordinates;
import com.anderslazis.avaj.weather.WeatherProvider;

public class WeatherTower extends Tower
{
	 public String getWeather(Coordinates p_coordinates){
		 return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
	 }
	public void changeWeather(){
		 super.conditionChanged();
	}
}
