package heisenbot.assessment2.ex1;

import heisenbot.RobotConfig;
import lejos.nxt.Button;
import lejos.util.Delay;

public class HelloWorld extends RobotConfig {

	public static void main(String[] args) {
		Button.waitForAnyPress();
		RobotConfig demo = new HelloWorld();
		demo.run();
	}

	@Override
	public void run() {
		int count = 0;
		System.out.println("Hello World");
		Button.waitForAnyPress();
		Delay.msDelay(1000);
		while (running) {
			if (Button.ENTER.isDown()) {
				if (count % 2 == 0) {
					squareLeft();
					count++;
				} else {
					squareRight();
					count++;
				}
				Delay.msDelay(1000);
			}

			if (Button.ESCAPE.isDown()) {
				running = false;
			}
		}
	}
}
