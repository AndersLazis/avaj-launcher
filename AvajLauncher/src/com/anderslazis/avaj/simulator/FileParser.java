package com.anderslazis.avaj.simulator;
import com.anderslazis.avaj.aircrafts.AircraftFactory;
import com.anderslazis.avaj.aircrafts.Coordinates;
import com.anderslazis.avaj.aircrafts.Flyable;
import java.util.*;

/**
 * The FileParser class is responsible for parsing a list of lines from a file
 * to create a fleet of aircraft objects. It extracts the number of weather cycles
 * and validates the aircraft data, ensuring correct formatting and parameter constraints.
 */
public class FileParser {

    private List<String> lines;
    private List<Flyable> fleet = new ArrayList<Flyable>();
    int numberWeatherCycles;

    public FileParser(List<String> lines) {
        this.lines = lines;
    }

    public List<Flyable> parseFile() {
        try {
            String weatherCycles = lines.get(0);
            try {
                numberWeatherCycles = Integer.parseInt(weatherCycles.trim());
                if (numberWeatherCycles < 1 || numberWeatherCycles > 10000) {
                    throw new IllegalArgumentException("Wrong number of weather changes cycles");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(AnsiColor.colorize((e.getMessage()), AnsiColor.ERROR));
                System.exit(1);
            }

            Set<String> aircraftNames = new HashSet<>();
            AircraftFactory factory = AircraftFactory.getInstance();
            for (int i = 1; i < lines.size(); i++) {
                try {
                    String line = lines.get(i).trim();
                    if (line.isEmpty() | line.isBlank())
                        continue;

                    String[] parts = line.split(" ");
                    if (parts.length != 5) {
                        throw new MyException("Invalid format at line " + (i + 1) +
                                ". Expected format: <Type> <Name> <Longitude> <Latitude> <Height>");
                    }

                    String type = parts[0];
                    String name = parts[1];
                    int longitude = Integer.parseInt(parts[2]);
                    int latitude = Integer.parseInt(parts[3]);
                    int height = Integer.parseInt(parts[4]);
                    if (longitude > 360 || longitude < 0 || latitude < 0 || latitude > 360 ||
                            height < 1 || height > 100) {
                        throw new MyException("Invalid limits of parameters in line " + (i + 1) + ". Please enter parameters" +
                                " according to limits: 0 < Longtitude < 360, 0 < Latitude < 360, 1 < Altitude(Height) < 100");
                    }
                    if (!aircraftNames.add(name)) {
                        throw new MyException("Every aircraft name should be unique! Please check line " + (i + 1));
                    }
                    Coordinates coordinates = Coordinates.create(longitude, latitude, height);
                    Flyable newAircraft = factory.newAircraft(type, name, coordinates);
                    fleet.add(newAircraft);
                } catch (MyException e){
                    System.out.println(AnsiColor.colorize(e.getMessage(), AnsiColor.RED));
                    System.exit(1);
                }
                }
        } catch (Exception e) {
            System.out.println(AnsiColor.colorize(e.getMessage(), AnsiColor.ERROR));
            System.exit(1);
        }
        return fleet;
    }
}