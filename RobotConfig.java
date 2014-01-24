package heisenbot;

import lejos.nxt.Motor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class RobotConfig {
	
	static RegulatedMotor left = Motor.B;
	static RegulatedMotor right = Motor.C;
	static DifferentialPilot pilot = new DifferentialPilot(56, 160, left, right);
	
	public static void SquareLeft() {
		pilot.travel(200);
		pilot.rotate(90);
	}
	
	public static void SquareRight() {
		pilot.travel(200);
		pilot.rotate(-90);
	}

}
