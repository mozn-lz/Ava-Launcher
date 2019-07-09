package wethinkcode.mk.control;

import wethinkcode.mk.vehicles.AircraftFactory;
import wethinkcode.mk.weather.WeatherTower;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

	public static PrintWriter writer = null;

	public static void main(String[] args) {
		WeatherTower weatherTower = new WeatherTower();
		AircraftFactory factory = new AircraftFactory();
		List<Flyable> aircraftList = new ArrayList<>();
		int simLoop = 0;
		int fileLineCount = 0;
		if(args.length == 1){	// check arguments
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(args[0]));
				String line = "";

				try {		// write file start
					writer = new PrintWriter(new File("./simulation.txt"));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}		//	write file
				while (line != null){	// line reading loop
					line = reader.readLine();
					if (line != null) {
						if (fileLineCount == 0) {
							try {
								if (isInteger(line)) {
									simLoop = Integer.valueOf(line);
								} else {
									System.exit(0);
								}
								// System.out.println(line);
							} catch (IllegalArgumentException ex) {
								System.out.println("Error: The first line is not a number.\n Exiting...");
								System.exit(0);
							}
						} else if (fileLineCount > 0) {
							String[] parts = line.split(" ");
							if (isInteger(parts[2]) && isInteger(parts[3]) && isInteger(parts[4])) {
								aircraftList.add(factory.newAircraft(parts[0], parts[1], Integer.valueOf(parts[2]), Integer.valueOf(parts[3]), Integer.valueOf(parts[4])));
							}
						}
						fileLineCount++;
					}
				}
				reader.close();		// close file reader
				weatherTower.simControler(aircraftList, simLoop);
				writer.close();		//	close file writer
			} catch (IOException e) {
				System.out.print("Error 'File reading error' :: ");
				e.printStackTrace();
			}
		} else {
			System.out.println("Argument error: number of arguments is not 1.");
		}
	}

	public static boolean isInteger(String s) {
		boolean isValidInteger = false;
		try
		{
		   Integer.parseInt(s);
		   isValidInteger = true;
		}
		catch (NumberFormatException e)
		{
		   System.out.println("Error: " + s+ " is not a number :: " + e);
		}
		return isValidInteger;
	}
}
