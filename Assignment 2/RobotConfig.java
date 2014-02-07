import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class RobotConfig {

	static RegulatedMotor l_motor = Motor.B;
    static RegulatedMotor r_motor = Motor.C;
    static DifferentialPilot heisenbot = new DifferentialPilot(56, 165, l_motor, r_motor);
	static LightSensor l_eye = new LightSensor(SensorPort.S1);
	static LightSensor r_eye = new LightSensor(SensorPort.S2);
	static int l_turnCondition = 36;
	static int r_turnCondition = 40;
	
	public static boolean straightCondition() {
		boolean run = false;
		if(l_eye.readValue() > l_turnCondition && r_eye.readValue() > r_turnCondition) {
			run = true;
		}
		return run;
	}
	
	public static boolean leftCondition() {
		boolean run = false;
		if(l_eye.readValue() < l_turnCondition && r_eye.readValue() > r_turnCondition) {
			run = true;
		}
		return run;
	}
	
	public static boolean rightCondition() {
		boolean run = false;
		if(l_eye.readValue() > l_turnCondition && r_eye.readValue() < r_turnCondition) {
			run = true;
		}
		return run;
	}
	
	public static boolean bothCondition() {
		boolean run = false;
		if(l_eye.readValue() < l_turnCondition && r_eye.readValue() < r_turnCondition) {
			run = true;
		}
		return run;
	}
	
	public static void explore() {
		heisenbot.travel(10);
		heisenbot.rotate(30);
	}
	
	public static void solveHairpinLeft() {
		heisenbot.quickStop();
		heisenbot.travel(60);
		heisenbot.rotate(70);
	}
	
	public static void solveHairpinRight() {
		heisenbot.quickStop();
		heisenbot.travel(60);
		heisenbot.rotate(-70);
	}
	 
	
}
