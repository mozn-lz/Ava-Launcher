import java.util.ArrayList;
import java.util.List;

public class SimControler {

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