package com.anderslazis.avaj.simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Simulator {
    public static void main(String[] args) {

    if (args.length < 1){
        System.out.println("Error: Please specify correct scenario file name in double quotes");
        return;
    }
    String fileName = args[0];
    List<String> lineList = new ArrayList<String>();

    try (BufferedReader br = new BufferedReader((new FileReader(fileName)))) {
        String line;
        while ((line = br.readLine()) != null){
                lineList.add(line);
            }
        }
    catch (IOException e){
        System.out.println("Error: error while reading file");
        e.printStackTrace();
    }
    FileParser parser = new FileParser(lineList);
    parser.parseFile();
//
//        for (int i = 0; i < lineList.size() ; i++) {
//            System.out.println(lineList.get(i));
//        }

    }
}
