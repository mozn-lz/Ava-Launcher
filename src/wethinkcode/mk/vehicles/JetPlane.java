package wethinkcode.mk.vehicles;

import wethinkcode.mk.control.Coordinates;
import wethinkcode.mk.control.Main;
import wethinkcode.mk.control.Flyable;
import wethinkcode.mk.weather.WeatherProvider;
import wethinkcode.mk.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;
	private String message;
	Main main = new Main();

	public JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {

		switch (WeatherProvider.getProvider().getCurrentWeather(coordinates)) {
			case "FOG":
				coordinates.setLatitude(coordinates.getLatitude() + 1);
				Main.writer.write("I can't see anything! It's foggy now!\n");
				Main.writer.flush();
				// message = "I can't see anything! It's foggy now!";
				break;
			case "RAIN":
				coordinates.setLatitude(coordinates.getLatitude() + 5);
				Main.writer.write("It's raining!\n");
				Main.writer.flush();
				// message = "It's raining!";
				break;
			case "SNOW":
				coordinates.setHeight(coordinates.getHeight() - 7);
				Main.writer.write("It's freezing! Stay warm!\n");
				Main.writer.flush();
				// message = "It's freezing! Stay warm!";
				break;
			case "SUN":
				coordinates.setLatitude(coordinates.getLatitude() + 10);
				coordinates.setHeight(coordinates.getHeight() + 2);
				Main.writer.write("It's hot! And bright. Bring some ice!\n");
				Main.writer.flush();
				// message = "It's hot! And bright. Bring some ice!";
				break;
			default:
				break;
		}
		if (coordinates.getHeight() <= 0) {
			weatherTower.unregister(this);
			// message = "We are landing at coordinates: " + coordinates.getLongitude() + " " + coordinates.getLatitude() + " " + 0;
			Main.writer.write("We are landing at coordinates: " + coordinates.getLongitude() + " " + coordinates.getLatitude() + " " + 0);
			Main.writer.flush();
		}
		if (coordinates.getHeight() > 100) {
			coordinates.setHeight(100);
		}
//		LogListener.log(toString() + ": " + message);
		// System.out.println(toString() + ": " + message);
	}

	@Override
	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);

		Main.writer.write("JetPlane#" + this.name + "(" + id + ") registered to weather tower.\n");
		Main.writer.flush();
 		// System.out.println("JetPlane#" + this.name + "(" + id + ") registered to weather tower.");
	}

	@Override
	public String toString() {
		return Aircraft.JetPlane + super.toString();
	}
}
