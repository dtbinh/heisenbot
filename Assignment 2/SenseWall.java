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
			if((distance - targetDistance) <= 0)
			{
				heisenbot.setTravelSpeed(distance-targetDistance);
				heisenbot.travel(-10, true);
			}
			// if the targetDistance has not been reached, go forward at a speed proportional to distance away
			else 
			{
				heisenbot.setTravelSpeed(distance-targetDistance);
				heisenbot.travel(10, true);
			}			

		}

	}

	public static void main(String[] args) {
		Button.waitForAnyPress();
		SenseWall go = new SenseWall();
		go.run();
		Button.waitForAnyPress();
	}

}
