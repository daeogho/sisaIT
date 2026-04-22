package test;

public class Car {
	protected String brend = "페라리";
	String color = "white";
	int maxSpeed = 180;
	int speed = 0;

	public Car() {}
		public void speedUp() {
			speed++;
			if(speed > maxSpeed){
				speed = maxSpeed;
			}
	}

}
