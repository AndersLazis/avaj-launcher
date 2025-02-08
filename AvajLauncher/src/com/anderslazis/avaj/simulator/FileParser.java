package com.anderslazis.avaj.simulator;
import java.util.*;


public class FileParser {

    private List<String> lines;

    public FileParser(List<String> lines) {
        this.lines = lines;
    }

    public void parseFile() {
        try {
            String weatherCycles = lines.get(0);
            try {
                int numberWeatherCycles = Integer.parseInt(weatherCycles.trim());
                if (numberWeatherCycles < 1 || numberWeatherCycles > 10000) {
                    throw new IllegalArgumentException("Wrong number of weather changes cycles");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.exit(1);
            }
            Set<String> aircraftNames = new HashSet<>();
            AircraftFactory factory = AircraftFactory.getInstance();
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split(" ");
                if (parts.length != 5){
                    throw new Exception("Invalid format in line " + (i+1));
                }
                String type = parts[0];
                String name = parts[1];

                    int longitude = Integer.parseInt(parts[2]);
                    int latitude = Integer.parseInt(parts[3]);
                    int height = Integer.parseInt(parts[3]);
                    if (longitude > 90 || longitude < 0 || latitude < 0 || latitude > 90 ||
                            height < 0 || height > 100) {
                        throw new Exception("Invalid limits of parameters in line " + (i + 1) + ". Please enter parameters" +
                                " according to limits: 0 < Longtitude < 90, 0 < Latitude < 90, 0 < Altitude < 100");
                }
                    if(!aircraftNames.add(name)){
                        throw new Exception("Error: Every aircraft name should be unique! Please check line " + (i+1));
                    }


                    //  CREATE AIRCRAFT

                    //REGISTER AIRCRAFT




            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}