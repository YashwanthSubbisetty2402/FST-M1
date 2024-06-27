package activities;

public class Activity1 {

	public static void main(String[] args) {

		Car Audi = new Car();

		Audi.sColor = "Red";
		Audi.sTransmission = "Automatic";
		Audi.iMake = 2020;
		Audi.iTyres = 4;
		Audi.iDoors = 4;

		Audi.displayCharactristics();
		Audi.accelarate();
		Audi.brake();
		

	}

}
