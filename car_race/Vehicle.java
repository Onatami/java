package car_race;

public class Vehicle {

	protected String model = null;
	protected String make = null;
	protected String year = null;
	protected int maxSpeed = 0;
	
	public Vehicle () {
		this.model = null;
		this.make = null;
		this.year = "2018";
		this.maxSpeed = 100;
	}
	public Vehicle (String make, String model, String year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}
	
	public void setSpeed(int speed) {
		this.maxSpeed = speed;
	}
	
	public String toString() {
		return("Year: " + year + "/tMake: " + make + "/tModel" + model + "/tMax speed: " + maxSpeed);
	}
}
