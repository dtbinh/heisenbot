package heisenbot;

import lejos.nxt.Button;
//import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
//import lejos.robotics.RegulatedMotor;
//import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.TouchSensor;

public class TouchTurn extends RobotConfig {
	public static void main(String[] args) {
		TouchSensor t_left = new TouchSensor(SensorPort.S1);
		TouchSensor t_right = new TouchSensor(SensorPort.S2);

		//RegulatedMotor left = Motor.B;
		//RegulatedMotor right = Motor.C;

		//DifferentialPilot pilot = new DifferentialPilot(56, 160, left, right);

		while (Button.ENTER.isUp()) {

			go();

			if (t_left.isPressed() || t_right.isPressed()) {
				avoidObstacleLeft();
			}
		}
	}
}
