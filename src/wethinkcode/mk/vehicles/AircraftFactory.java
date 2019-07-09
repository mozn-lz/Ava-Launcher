package wethinkcode.mk.vehicles;

import wethinkcode.mk.vehicles.Baloon;
import wethinkcode.mk.vehicles.Helicopter;
import wethinkcode.mk.vehicles.JetPlane;
import wethinkcode.mk.control.Coordinates;
import wethinkcode.mk.control.Flyable;

public class AircraftFactory {

	public AircraftFactory() {

	}

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

		if (type == "JetPlane" || type == "Baloon" || type == "Helicopter") {
			switch (type) {
				case "JetPlane":
					JetPlane plane = new JetPlane(name, new Coordinates(longitude, latitude, height));
					return plane;
				case "Baloon":
					Baloon baloon = new Baloon(name, new Coordinates(longitude, latitude, height));
					return baloon;
				case "Helicopter":
					Helicopter helicopter = new Helicopter(name, new Coordinates(longitude, latitude, height));
					return helicopter;
				default:
					System.out.println("Error: Flyable type is not recognized.");
					System.exit(0);
					return null;
			}
		} else {
			System.out.println("Error: '" + type + "' is not a valid aircraft type");
		}
		return null;
	}
}
