package heisenbot.assessment2.ex2;

import heisenbot.RobotConfig;
import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class TouchTurnLoop extends RobotConfig {

	TouchSensor t_left = new TouchSensor(SensorPort.S1);
	TouchSensor t_right = new TouchSensor(SensorPort.S2);

	public static void main(String[] args) {

		RobotConfig demo = new TouchTurnLoop();
		demo.run();
		
	}

	@Override
	public void run() {
		while (Button.ENTER.isUp()) {

			pilot.forward();

			if (t_left.isPressed() || t_right.isPressed()) {
				avoidObstacleLeft();
			}
		}
	}
}