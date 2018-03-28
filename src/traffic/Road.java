package traffic;

import java.util.ArrayList;
import java.util.List;

public class Road {

	private List<Car> cars = new ArrayList<>();
	private int safeDistance = 1;
	private int speedLimit = 15;
	
	public void addCar() {
		Car car = new Car();
		car.id = cars.size();
		car.position = 359 - cars.size();
		car.speed = 0;
		cars.add(car);
	}
	
	// Set the initial speed of all cars
	public void setInitialSpeed(double speed) {
		for (Car car : cars) {
			car.speed = speed;
		}
	}
	
	public void changeCarSpeed(int id, double newSpeed) {
		Car car = cars.get(id);
		car.speed = newSpeed;
	}
	
	private Car getCarInFront(Car car) {
		int carIndex = cars.indexOf(car);
		int indexOfCarInFront;
		Car carInFront;
		
		if (carIndex - 1 < 0) {
			indexOfCarInFront = cars.size() - 1;	
			carInFront = cars.get(indexOfCarInFront);
		} else {
			indexOfCarInFront = carIndex - 1;
			carInFront = cars.get(indexOfCarInFront);
		}
		
		return carInFront;
	}
	
	private double calculateDistanceBetweenCars(Car car1, Car car2) {
		double disToCarInFront;				
		if (car2.position - car1.position < 0) {
			disToCarInFront = car2.position - car1.position + 360;
		} else {
			disToCarInFront = car2.position - car1.position;
		}
		return disToCarInFront;
	}
	
	public void incrementTime() {
		for (Car car : cars) {
			Car carInFront = getCarInFront(car);
			double disToCarInFront = calculateDistanceBetweenCars(car, carInFront);			
			
			if (disToCarInFront - car.speed < safeDistance){
				car.speed = 0;
			}			
			if (disToCarInFront - car.speed > safeDistance && car.speed < speedLimit){
				car.speed++;
			}	
			
			car.position += car.speed;
			if (car.position > 359) {
				car.position -= 360;
			}
		}
	}
	
	public void printCarsPosition(int time){
		System.out.print(time + "--- ");
		for (Car car : cars) {
			System.out.print(car.id + ": " + car.position + ", speed: " + car.speed + ",\t\t");
		}
		System.out.println();
	}

	public void printCarSpeedCSV(int time){
		System.out.print(time + ",");
		for (Car car : cars) {
			System.out.print(car.speed + ",");
		}
		System.out.println();
	}
	
}
