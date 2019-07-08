package wethinkcode.mk.control;

import wethinkcode.mk.weather.WeatherTower;

public interface Flyable {
	void updateConditions();
	void registerTower(WeatherTower weatherTower);
}
