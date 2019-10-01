package car_race;

public class Race {

	public static void main(String[] args) {
		int car1 = 0;
		int car2 = 0;
		int car3 = 0;

		// Car movements
		while (car1 < 100 && car2 < 100 && car3 < 100) {
			car1 += 3;
			car2 += (int) Math.floor((Math.random() * 3) + 2);
			car3 += (int) Math.floor((Math.random() * 5) + 1);
		
			System.out.println("Car 1 = " + car1 + "\n" + "Car 2 = " + car2 + "\n" + "Car 3 = " + car3 + "\n");

		}

		System.out.println("Car 1 = " + car1 + "\n" + "Car 2 = " + car2 + "\n" + "Car 3 = " + car3);
		printWinner(car1, car2, car3);
	}

	public static void printWinner(int car1, int car2, int car3) {

		if (car1 > car2 && car1 > car3) {
			System.out.println("Car 1 is the winner!");

		} else if (car2 > car1 && car2 > car3) {
			System.out.println("Car 2 is the winner!");

		} else if (car3 > car1 && car3 > car2) {
			System.out.println("Car 3 is the winner!");

		} else
			System.out.println("Its a tie!");

	}

}
