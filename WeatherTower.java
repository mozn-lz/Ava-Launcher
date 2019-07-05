import java.util.List;

public class WeatherTower extends Tower  {
	String changeWeather(Coordinates coordinates){
		return null;
	}
	void changeWeather(){

	}

	@Override
	public void register(Flyable flyable) {
		// System.out.println("Tower says:" +flyable.type+ "#" +flyable.name+ "(" +flyable.id+ ") registered to weather tower.");
		System.out.println("Registering");
	}

	@Override
	public void unregister(Flyable flyable) {
		// System.out.println("Tower says:" +flyable.type+ "#" +flyable.name+ "("+flyable.id+ "landing.");
		// simControler.removeit();
		System.out.println("Unregistering");
	}

	@Override
	public void conditionChanged() {

	}


	void simControler(List<Flyable> aircraftList, int simLoop) {

		System.out.println("Registering Aircrafts");

		for(int i = 0; i<aircraftList.size(); i++) {
			aircraftList.get(i).registerTower(new WeatherTower());
		}
		
		while (simLoop > 0) {
			System.out.println("\n\t\t\tUpdating Conditions: " + simLoop);
			for(int i = 0; i<aircraftList.size(); i++) {
				aircraftList.get(i).updateConditions();
			}
			simLoop--;
		}
	}
}
