import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

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
				while (line != null){	// line reafing loop
					line = reader.readLine();
					if (line != null) {
						if (fileLineCount == 0) {
							try {
								simLoop = Integer.valueOf(line);
								System.out.println(line);
							} catch (IllegalArgumentException ex) {
								System.out.println("The first line is not a number.\n Exiting...");
								System.exit(0);
							}
						} else if (fileLineCount > 0) {
							String[] parts = line.split(" ");
							aircraftList.add(factory.newAircraft(parts[0], parts[1], Integer.valueOf(parts[2]), Integer.valueOf(parts[3]), Integer.valueOf(parts[4])));
						}
						fileLineCount++;
					}
				}
				reader.close();
				weatherTower.simControler(aircraftList, simLoop);
			} catch (IOException e) {
				System.out.print("File reading error: ");
				e.printStackTrace();
			}
		} else {
			System.out.println("Argument error: number of arguments is not 1.");
		}
	}

}
