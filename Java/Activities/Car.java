package activities;

public class Car {

	String sColor;
	String sTransmission;
	int iMake;
	int iTyres;
	int iDoors;

	public void displayCharactristics() {
		System.out.println("Make of the Car: " + iMake);
		System.out.println("Transmission of the Car: " + sTransmission);
		System.out.println("Color of the Car: " + sColor);
		System.out.println("Number of Tyres in the Car: " + iTyres);
		System.out.println("Number of Doors in the Car: " + iDoors);

	}

	public void accelarate() {
		System.out.println("Car is moving forward");
	}

	public void brake() {
		System.out.println("Car has stopped");
	}

}