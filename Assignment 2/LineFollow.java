import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;


public class LineFollow extends RobotConfig {
	
	static RegulatedMotor l_motor = Motor.B;
    static RegulatedMotor r_motor = Motor.C;
    static DifferentialPilot heisenbot = new DifferentialPilot(56, 165, l_motor, r_motor);
	static LightSensor l_eye = new LightSensor(SensorPort.S1);
	static LightSensor r_eye = new LightSensor(SensorPort.S2);
	static int arcVal = 20;
	static int arcAng = 20;
	
	public static void main(String[] args) {
		
		Button.waitForAnyPress();
		heisenbot.setTravelSpeed(500);
		Delay.msDelay(500);
		
		while(Button.ENTER.isUp()) {
			if(straightCondition()) { //line between eyes
				heisenbot.setTravelSpeed(500);
				heisenbot.travel(20, true);
			} else if(bothCondition()) { //line under both eyes
				heisenbot.quickStop();
				System.out.println("it works");
				Button.waitForAnyPress();
				Delay.msDelay(500);
				heisenbot.travel(20);
			} else if(leftCondition()) { //line under left eye
				heisenbot.setTravelSpeed(300);
				System.out.println("LEFT");
				heisenbot.arc(arcVal, arcAng, true);
			} else if(rightCondition()) { //line under right eye
				heisenbot.setTravelSpeed(300);
				System.out.println("RIGHT");
				heisenbot.arc(-arcVal, -arcAng, true);
			} else {
				heisenbot.quickStop();
				System.out.println("something went wrong");
			}
		}
	}
}
