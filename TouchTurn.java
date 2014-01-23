import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.TouchSensor;

public class TouchTurn
{
		public static void main(String[] args) 
		{
			TouchSensor touch = new TouchSensor(SensorPort.S1);

			RegulatedMotor left = Motor.B;
			RegulatedMotor right = Motor.C;
			
			DifferentialPilot pilot = new DifferentialPilot(56, 160, left, right);
			
			while(Button.ENTER.isUp())
			{
				pilot.travel(500, true);
				
				if(touch.isPressed())
				{
					pilot.travel(-60);
					pilot.rotate(90);
				}
			}
		}
}
