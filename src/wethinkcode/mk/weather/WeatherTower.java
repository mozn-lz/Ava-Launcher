package wethinkcode.mk.weather;

import java.util.List;

public class WeatherTower extends Tower  {

	private static boolean killAircraft = false;

	void simControler(List<Flyable> aircraftList, int simLoop) {

		System.out.println("Registering Aircrafts");

		for(int i = 0; i<aircraftList.size(); i++) {
			aircraftList.get(i).registerTower(new WeatherTower());
		}
		
		while (simLoop > 0) {
			System.out.println("\n____________________________Updating Conditions: " + simLoop + "____________________________");
			for(int i = 0; i<aircraftList.size(); i++) {
				aircraftList.get(i).updateConditions();

					// System.out.println("\t\t\tkillAircraftt : " + killAircraft);
					if (killAircraft == true) {
					System.out.println("\t\t\t\t\t\tDeleting aircraft : " + aircraftList.get(i));
					aircraftList.remove(i);
					killAircraft = false;
				}
			}
			simLoop--;
		}
	}

	String changeWeather(Coordinates coordinates){
		return null;
	}
	void changeWeather(){

	}

	@Override
	public void register(Flyable flyable) {
		// System.out.println("Tower says:" +flyable.type+ "#" +flyable.name+ "(" +flyable.id+ ") registered to weather tower.");
		// System.out.println("Registering");
	}

	@Override
	public void unregister(Flyable flyable) {
		// System.out.println("Tower says:" +flyable.type+ "#" +flyable.name+ "("+flyable.id+ "landing.");
		// simControler.removeit();
					killAircraft = true;
					// System.out.println("\n\t\t\t\t\t\t****Unregistering****\n");
	}

	@Override
	public void conditionChanged() {

	}


}
