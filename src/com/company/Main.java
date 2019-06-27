package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		AircraftFactory factory = new AircraftFactory();
//		Flyable fly;
		String file;
		int i = 0;
		if(args.length == 1){	// check arguments
			if(args.length == 0) {
				file = args[1];
			} else{
				file = "scenario.txt";
			}
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(file));
				String line = reader.readLine();
				while (line != null){
//                call other function
					if (i == 0) {
						try {
							int simLoop = Integer.valueOf(line);
						} catch (IllegalArgumentException ex) {
							System.out.println("First line is not an integer number");
						}
					}
					if (i > 0) {
						String[] parts = line.split(" ");
						factory.newAircraft(parts[0], parts[1], Integer.valueOf(parts[2]), Integer.valueOf(parts[3]), Integer.valueOf(parts[4]));
						// create checker to verify if parts[2-4] are ints
					}
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// print args error
			System.out.println("Argument error");
		}
	}
}
