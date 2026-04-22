package test;

public class SportsCar extends Car {

	public SportsCar() {

	}

	@Override
	public void speedUp() {
		super.speed += 10;
		if (speed >= maxSpeed) {
			speed = maxSpeed;
		}

	}

	public void speedDown() {

		super.speed -= 2;
		if (speed < 0) {
			speed = 0;
		}
	}

	public static void main(String[] args) {
		new SportsCar();

	}

}
