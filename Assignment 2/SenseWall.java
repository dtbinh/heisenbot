import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.OpticalDistanceSensor;

public class SenseWall extends RobotConfig {

	OpticalDistanceSensor sensy = new OpticalDistanceSensor(SensorPort.S3);
	boolean running;

	public SenseWall() {
		running = true;
	}

	public void run() {

		while (running) {
			int distance = sensy.getDistance();
			int targetDistance = 300;

			// if the targetDistance has been reached, reverse at a speed proportional to distance away
			// when the actual distance is smaller than target distance (IE too close to target) distance - targetDistance will be negative.
			if((distance - targetDistance) <= 0)
			{
				heisenbot.setTravelSpeed(distance-targetDistance);
				heisenbot.travel(-10, true);
			}
			// if the targetDistance has not been reached, go forward at a speed proportional to distance away
			// when the actual distance is greater than the target distance (IE too far away) distance - targetDistance will be positive.
			//this will be the case whenever the first condition is not true, therefore else rather than elseif is used.
			else 
			{
				heisenbot.setTravelSpeed(distance-targetDistance);
				heisenbot.travel(10, true);
			}			

		}

	}
	//the main method ensures that the program will loop from the initial button press until ending button press.
	public static void main(String[] args) {
		Button.waitForAnyPress();
		SenseWall go = new SenseWall();
		go.run();
		Button.waitForAnyPress();
	}

}
