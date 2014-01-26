package heisenbot.assessment2.ex3;

import heisenbot.RobotConfig;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;


public class Escape extends RobotConfig {

	RegulatedMotor left = Motor.B;
	RegulatedMotor right = Motor.C;
	DifferentialPilot pilot = new DifferentialPilot(56, 165, left, right);
	TouchSensor t_left = new TouchSensor(SensorPort.S1);
	TouchSensor t_right = new TouchSensor(SensorPort.S2);
	UltrasonicSensor radar = new UltrasonicSensor(SensorPort.S3);

	public static void main(String[] args) {

		RobotConfig demo = new Escape();
		demo.run();
	}

	@Override
	public void run() {
		System.out.println("I am the one who knocks.");
		System.out.println("PRESS ENTER YO");

		Button.waitForAnyPress();
		Delay.msDelay(1000);

		// this code works on the principle that, as long as you hug the left
		// wall, you will reach the exit
		// therefore bugs/infinite loops may arise if:
		//
		// The robot turns a full 180 degrees (as it will hug the wrong left
		// wall causing it to go to the start again)
		// The robot gets into a 45 degree corner trap.
		//
		// thus far those are the known ones.

		while (Button.ENTER.isUp()) {
			pilot.travel(300); // potentially make parameters (300, true); and
								// test that. The 'true' makes it run the rest
								// of the code whilst travelling
			if (radar.getDistance() > 15) {
				stop();
				exploreLeft(); // if HeisenBot is getting stuck, try changing
								// the pilot.rotate(x); values in the
								// RobotoConfig for this method to a smaller /
								// greater value
			}
			if (t_left.isPressed() || t_right.isPressed()) {
				stop();
				if (radar.getDistance() < 15) {
					revRight();
				} else {
					revLeft();
					// if its getting into infinite loops, try adding a
					// 'pilot.travel(500);' here. This should prevent it from
					// getting stuck in a square loop in large open places
				}
			}
		}

	}

}