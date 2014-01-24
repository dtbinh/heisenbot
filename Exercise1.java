package heisenbot;

import lejos.nxt.Button;
//import lejos.nxt.Motor;
//import lejos.nxt.NXTRegulatedMotor;
//import lejos.robotics.RegulatedMotor;
//import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

public class Exercise1 extends RobotConfig {

	public static void main(String[] args) 
	{
		//RegulatedMotor left = Motor.B;
		//RegulatedMotor right = Motor.C;
		//DifferentialPilot pilot = new DifferentialPilot(56, 160, left, right);
		
		System.out.println("Hello World");
		Button.waitForAnyPress();
		
		Delay.msDelay(1000);
		
		while(Button.ENTER.isUp())
		{
			SquareLeft();
		}
		
		Delay.msDelay(1000);
		
		while(Button.ENTER.isUp())
		{
			SquareRight();
		}
		
	}
}