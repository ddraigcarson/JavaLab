package traffic;

public class Traffic {

	public void execute(){
		// need a road
		// need a bunch of cars
		Road road = new Road();
		
		int carLimit = 300;		
		for (int i=0 ; i<carLimit ; i++) {
			road.addCar();	
		}		
		road.setInitialSpeed(10);
		
		for (int i=0 ; i<carLimit ; i++) {
			System.out.print(i + ",");
		}
		System.out.println();	
		
		for (int i=0 ; i<100 ; i++) {
			
			if (i==20) {
				road.changeCarSpeed(3, 1);
				//System.out.println("Car messed with: " + 3);
			}
			
			road.incrementTime();
			road.printCarsPosition(i);
			//road.printCarSpeedCSV(i);
		}
	}
	
	private int randomInt(int min, int max) {
		return min + (int)Math.floor(Math.random()*(max-min));
	}
	
}
