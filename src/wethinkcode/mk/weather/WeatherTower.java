package wethinkcode.mk.weather;

import wethinkcode.mk.control.Coordinates;
import wethinkcode.mk.control.Flyable;
import wethinkcode.mk.control.Tower;

import java.util.List;

public class WeatherTower extends Tower {

	private static boolean killAircraft = false;

	public void simControler(List<Flyable> aircraftList, int simLoop) {

		for (int i = 0; i < aircraftList.size(); i++) {
			aircraftList.get(i).registerTower(new WeatherTower());
		}
		if (simLoop < 1) {
			System.out.println(
					"Oh! it seams the number of simulations is less than 1, \n Dont woury about it, I'll perform a magic trick to fix it");
			simLoop *= -1;
			if (simLoop == 0) {
				simLoop++;
			}
		}
		while (simLoop > 0) {

			for (int i = 0; i < aircraftList.size(); i++) {
				aircraftList.get(i).updateConditions();

				if (killAircraft == true) {

					aircraftList.remove(i);
					killAircraft = false;
				}
			}
			simLoop--;
		}
	}

	String changeWeather(Coordinates coordinates) {
		return null;
	}

	void changeWeather() {

	}

	@Override
	public void register(Flyable flyable) {
	}

	@Override
	public void unregister(Flyable flyable) {

		killAircraft = true;

	}

	@Override
	public void conditionChanged() {

	}

}
