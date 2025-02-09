package com.anderslazis.avaj.weather;
import com.anderslazis.avaj.aircrafts.Coordinates;
import java.util.Random;

/**
 * Singleton class that generates random weather
 */
public class WeatherProvider{

	private static WeatherProvider instance;
	private final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider(){}

	public String getCurrentWeather(Coordinates p_coordinates){
		Random random = new Random();
		int randomWeather = random.nextInt(4) + 1;
		return weather[randomWeather];
	};

	public static synchronized WeatherProvider getInstance() {
		if (instance == null){
			instance = new WeatherProvider();
		}
		return instance;
	}
}