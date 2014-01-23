import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class Exercise1 {

	public static void main(String[] args) 
	{
		RegulatedMotor left = Motor.B;
		RegulatedMotor right = Motor.C;
		DifferentialPilot pilot = new DifferentialPilot(56, 160, left, right);
		
		System.out.println("Hello World");
		Button.waitForAnyPress();
		
		while(Button.ENTER.isUp())
		{
			pilot.travel(200);
			pilot.rotate(90);
		}
		
		while(Button.ENTER.isUp())
		{
			pilot.travel(200);
			pilot.rotate(-90);
		}
		
	}
}
