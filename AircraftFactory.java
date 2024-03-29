

public class AircraftFactory {

	public AircraftFactory() {

	}

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

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
				System.out.println("Type of Flyable is not recognized.");
				System.exit(0);
				return null;
		}
	}
}
