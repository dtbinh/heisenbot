package heisenbot.assessment2.ex2;


import heisenbot.assessment2.RobotConfig;
import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;

public class TouchTurnEvent extends RobotConfig implements SensorPortListener {

	//chat me "bananas" if you're reading this...
	private final SensorPort p1;

	public TouchTurnEvent(SensorPort port1) {
		super();
		p1 = port1;

	}

	public void run() {
		p1.addSensorPortListener(this);
		pilot.forward();

	}

	public static void main(String[] args) {
		Button.waitForAnyPress();
		RobotConfig demo = new TouchTurnEvent(SensorPort.S1);
		demo.run();
		Button.waitForAnyPress();

	}

	@Override
	public void stateChanged(SensorPort aSource, int aOldValue, int aNewValue) {

		if (aNewValue < aOldValue && (aOldValue - aNewValue) > 500) {
			avoidDeadEnd();
			pilot.forward();
		}

	}

}