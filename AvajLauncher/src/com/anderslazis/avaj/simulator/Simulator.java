package com.anderslazis.avaj.simulator;
import com.anderslazis.avaj.aircrafts.Flyable;
import com.anderslazis.avaj.tower.WeatherTower;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Simulator {
	private static List<Flyable> aircraftFleet;

	public static void main(String[] args) {

		if (args.length < 1) {
			System.out.println("Error: Please specify correct scenario file name in double quotes");
			return;
		}
		String fileName = args[0];
		List<String> lineList = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader((new FileReader(fileName)))) {
			String line;
			while ((line = br.readLine()) != null) {
				lineList.add(line);
			}
		} catch (IOException e) {
			System.out.println("Error: error while reading file");
			e.printStackTrace();
		}

		try {
			WeatherTower weatherTower = new WeatherTower();
			FileParser parser = new FileParser(lineList);
			aircraftFleet = parser.parseFile();
			for (Flyable aircraft : aircraftFleet) {
				aircraft.registerTower(weatherTower);
			}

//			/* Print out all aircrafts and their coordinates */
//			System.out.println("\n === * Parsed aircrafts from a scenario file and their parameters * ===");
//			for (Flyable aircraft : aircraftFleet) {
//				System.out.println(	aircraft.getType() + " " +
//									aircraft.getName() +	" " +
//									aircraft.getLongtitude() + " " +
//									aircraft.getLatitude() + " " +
//									aircraft.getHeight());
//			}
//			System.out.println("=======================================");
			AnsiColor.entrySign();
			for (int i = 1; i <= parser.numberWeatherCycles; i++) {
				System.out.println(AnsiColor.colorize((" === * Weather has been generated in " + i + " time * === "), AnsiColor.CYAN));
				weatherTower.changeWeather();
			}

			/* Print out all aircrafts and their coordinates */
			System.out.println("\n === * End of simulation: all aircrafts in the air: * ===");
			for (Flyable aircraft : aircraftFleet) {
				//System.out.println("Last weather: " + weatherTower.getWeather(aircraft.getCoordinates()));
				System.out.println(AnsiColor.colorize((aircraft.getType() + " " +
									aircraft.getName() + " " +
									aircraft.getLongtitude() + " " +
									aircraft.getLatitude() + " " +
						(aircraft.getHeight() <=0 ? "[Landed]" : aircraft.getHeight())), AnsiColor.YELLOW));
			}
			System.out.println("=======================================");

		} catch ( Exception e) {
			System.out.println(e.getMessage());
		}
		return;
	}
}
