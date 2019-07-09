package wethinkcode.mk.vehicles;

import wethinkcode.mk.control.Coordinates;
import wethinkcode.mk.control.Flyable;
import wethinkcode.mk.control.Main;
import wethinkcode.mk.weather.WeatherProvider;
import wethinkcode.mk.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	private String message;

	public Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {

		switch (WeatherProvider.getProvider().getCurrentWeather(coordinates)) {
		case "FOG":
			coordinates.setLongitude(coordinates.getLongitude() + 1);
			Main.writer.write("Helicopter#" + this.name + "(" + id + ") : I can't see anything! It's foggy now!\n");
			Main.writer.flush();
			break;
		case "RAIN":
			coordinates.setLongitude(coordinates.getLongitude() + 5);
			Main.writer.write("Helicopter#" + this.name + "(" + id + ") : It's raining!\n");
			Main.writer.flush();
			break;
		case "SNOW":
			coordinates.setHeight(coordinates.getHeight() - 12);
			Main.writer.write("Helicopter#" + this.name + "(" + id + ") : It's freezing!\n");
			Main.writer.flush();
			break;
		case "SUN":
			coordinates.setLongitude(coordinates.getLongitude() + 10);
			coordinates.setHeight(coordinates.getHeight() + 2);
			Main.writer.write("Helicopter#" + this.name + "(" + id + ") : It's hot! and bright\n");
			Main.writer.flush();
			break;
		default:
			break;
		}
		if (coordinates.getHeight() <= 0) {
			weatherTower.unregister(this);
			Main.writer.write("Helicopter#" + this.name + "(" + id + ") : We are landing at coordinates: "
					+ coordinates.getLongitude() + " " + coordinates.getLatitude() + " " + 0 + "\n");
			Main.writer.flush();
		}
		if (coordinates.getHeight() > 100) {
			coordinates.setHeight(100);
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);

		Main.writer.write("Helicopter#" + this.name + "(" + id + ") registered to weather tower.\n");
		Main.writer.flush();
	}

	@Override
	public String toString() {
		return Aircraft.Helicopter + super.toString();
	}
}
