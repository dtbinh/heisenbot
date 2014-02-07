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
	
	public static void main(String[] args) {
		
		Button.waitForAnyPress();
		heisenbot.setTravelSpeed(800);
		Delay.msDelay(500);
		
		while(Button.ENTER.isUp()) {
			if(straightCondition()) { //line between eyes
				heisenbot.travel(10, true);
			} else if(leftCondition()) { //line under left eye
				heisenbot.arcForward(20);
				if(bothCondition()) {
					solveHairpinLeft();
				}
			} else if(rightCondition()) { //line under right eye
				heisenbot.arcForward(-20);
				if(bothCondition()) {
					solveHairpinRight();
				}
			} //else if(bothCondition()) { //line under both eyes
				//heisenbot.quickStop();
				//explore();
			//}
		}

	}

}
