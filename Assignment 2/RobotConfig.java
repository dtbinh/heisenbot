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
	static int arcRad = 40;
	static int arcAng = 20;
	static int route = 0;
	
	//he moves forward...
	public static void straight() {
		heisenbot.travel(10, true);
	}

	//goes straight over junction...
	public static void juncStraight() {
		heisenbot.travel(20);
		straight();
	}
	
	//turns round...
	public static void reverse() {
		heisenbot.rotate(180);
		straight();
	}

	//decides on action at a junction...
	public static void both() {
		heisenbot.quickStop();
		System.out.println("junction");
		if(route == 0) {
			reverse();
		} else if(route == 1) {
			juncRight();
		} else if(route == 2) {
			juncLeft();
		} else if(route == 3) {
			juncLeft();
		} else if(route == 4) {
			reverse();
		} else if(route == 5) {
			juncLeft();
		} else if(route == 6) {
			reverse();
		} else if(route == 7) {
			juncLeft();
		} else if(route == 8) {
			juncStraight();
		} else if(route == 9) {
			juncRight();
		} else if(route == 10) {
			juncStraight();
		} else if(route == 11) {
			juncRight();
		} else if(route == 12) {
			juncStraight();
		} else if(route == 13) {
			juncRight();
			route = 0;
		}

		System.out.println("Junction successful");
	}

	//curves to the left
	public static void left() {
		System.out.println("LEFT");
		heisenbot.arc(arcRad, arcAng, false);
	}
	
	//turns left
	public static void juncLeft() {
		heisenbot.travel(75);
		heisenbot.rotate(90);
	}

	//curves to the right
	public static void right() {
		System.out.println("RIGHT");
		heisenbot.arc(-arcRad, -arcAng, false);
	}

	//turns right
	public static void juncRight() {
		heisenbot.travel(75);
		heisenbot.rotate(-90);
	}

	//checks for a junction
	public static boolean juncCheck() {
		boolean run = false;
		if(l_eye.readValue() < l_turnCondition && r_eye.readValue() < r_turnCondition) {
			run = true;
		}
		return run;
	}

	//unused
	public static void solveHairpinLeft() {
		System.out.println("HAIRPIN LEFT");
		heisenbot.travel(60);
		heisenbot.rotate(70);
	}					
	
	//unused
	public static void solveHairpinRight() {
		System.out.println("HAIRPIN RIGHT");
		heisenbot.travel(60);
		heisenbot.rotate(-70);
	}
}
