import lejos.nxt.Button;
//import lejos.nxt.LightSensor;
//import lejos.nxt.Motor;
//import lejos.nxt.SensorPort;
//import lejos.robotics.RegulatedMotor;
//import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;


public class LineFollow extends RobotConfig {

	//static RegulatedMotor l_motor = Motor.B;
    	//static RegulatedMotor r_motor = Motor.C;
    	//static DifferentialPilot heisenbot = new DifferentialPilot(56, 153, l_motor, r_motor);
	//static LightSensor l_eye = new LightSensor(SensorPort.S1);
	//static LightSensor r_eye = new LightSensor(SensorPort.S2);

	public static void main(String[] args) {

		Button.waitForAnyPress();
		Delay.msDelay(500);

		heisenbot.setTravelSpeed(100);
		heisenbot.setRotateSpeed(100);

		while(Button.ENTER.isUp()) {

			int l = l_eye.readValue();
			int r = r_eye.readValue();

			if(l >= l_turnCondition && r >= r_turnCondition) { //line between eyes
				if(juncCheck()) {
					both();
					route++;
				} else {
					straight();
				}
			} 

			if(l_eye.readValue() < l_turnCondition && r_eye.readValue() < r_turnCondition) { //line under both eyes 
				both();
				route++;
			} 

			if(l <= l_turnCondition && r >= r_turnCondition) { //line under left eye
				heisenbot.travel(10);
				if(juncCheck()) {
					both();
					route++;
				} else {
					left();
				}
				System.out.println("turn successful");
			} 

			if(l >= l_turnCondition && r <= r_turnCondition) { //line under right eye
				heisenbot.travel(10);
				if(juncCheck()) {
					both();
					route++;
				} else {
					right();
				}
				System.out.println("turn successful");
			}
		}
	}
}

