package com.company;

public class AircraftFactory implements Flyable {

	Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		switch (type) {
			case "JetPlane":
				return new JetPlane(name, new Coordinates(longitude, latitude, height));
			case "Baloon":
				return new Baloon(name, new Coordinates(longitude, latitude, height));
			case "Helicopter":
				return new Helicopter(name, new Coordinates(longitude, latitude, height));
			default:
				System.out.println("Airceaft identification error\n");
		}
		return null;
	}

	static void updateConditions(){

		return;
	}

	static void registerTower(WeatherTower weatherTower){
//		String type =
//		String name
//		int longitude
//		int latitude
//		int height
		return;
	}
}
