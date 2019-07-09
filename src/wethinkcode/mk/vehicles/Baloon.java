package wethinkcode.mk.vehicles;

import wethinkcode.mk.control.Coordinates;
import wethinkcode.mk.control.Flyable;
import wethinkcode.mk.control.Main;
import wethinkcode.mk.weather.WeatherProvider;
import wethinkcode.mk.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	private String message;


	protected Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		switch (WeatherProvider.getProvider().getCurrentWeather(coordinates)) {
			case "FOG":
				coordinates.setHeight(coordinates.getHeight() - 3);
				// message = "I can't see anything! It's foggy now!";
				Main.writer.write("Baloon#" + this.name + "(" + id + ") : I can't see anything! It's foggy now!\n");
				Main.writer.flush();
				break;
			case "RAIN":
				coordinates.setHeight(coordinates.getHeight() - 5);
				// message = "It's watery! Give me some towel";
				Main.writer.write("Baloon#" + this.name + "(" + id + ") : It's watery! Give me some towel\n");
				Main.writer.flush();
				break;
			case "SNOW":
				coordinates.setHeight(coordinates.getHeight() - 15);
				// message = "It's freezing! Stuard, bring me hot tea!";
				Main.writer.write("Baloon#" + this.name + "(" + id + ") : It's freezing! Stuard, bring me hot tea!\n");
				Main.writer.flush();
				break;
			case "SUN":
				coordinates.setLongitude(coordinates.getLongitude() + 2);
				coordinates.setHeight(coordinates.getHeight() + 4);
				// message = "It's hot! and bright";
				Main.writer.write("Baloon#" + this.name + "(" + id + ") : It's hot! and bright\n");
				Main.writer.flush();
				break;
			default:
				break;
		}
		if (coordinates.getHeight() <= 0) {
			weatherTower.unregister(this);
			// message = ("We are landing at coordinates: " + coordinates.getLongitude() + " " + coordinates.getLatitude() + " " + 0);
			Main.writer.write("Baloon#" + this.name + "(" + id + ") : We are landing at coordinates: " + coordinates.getLongitude() + " " + coordinates.getLatitude() + " " + 0);
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

 		// System.out.println("Baloon#" + this.name + "(" + id + ") registered to weather tower.");
		Main.writer.write("Baloon#" + this.name + "(" + id + ") registered to weather tower.\n");
		Main.writer.flush();
	}

	@Override
	public String toString() {
		return Aircraft.Baloon + super.toString();
	}
}

