package ex2;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import lejos.nxt.Motor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
  
public abstract class HeisenRun implements Runnable {
  
//I'm aware this is a similar thing to RobotConfig, I've just not got around to rewriting TouchTurnEvent yet, so am committing
    protected boolean running = true;
    private static final RegulatedMotor leftMotor = Motor.B;
    private static final RegulatedMotor rightMotor = Motor.C;
    protected static DifferentialPilot pilot = new DifferentialPilot(56, 160,
            leftMotor, rightMotor);
  
    public HeisenRun() {
        Button.ESCAPE.addButtonListener(new ButtonListener() {
            public void buttonReleased(Button b) {
                running = false;
            }
  
            public void buttonPressed(Button b) {
  
            }
  
        });
  
    }
  
    public static void go() {
        pilot.travel(800, true);
    }
  
    public static void stop() {
        pilot.quickStop();
    }
  
    public static void squareLeft() {
        pilot.travel(200);
        pilot.rotate(90);
    }
  
    public static void squareRight() {
        pilot.travel(200);
        pilot.rotate(-90);
    }
  
    public static void avoidObstacleLeft() {
        pilot.travel(-60);
        pilot.rotate(90);
    }
  
    public static void avoidObstacleRight() {
        pilot.travel(-60);
        pilot.rotate(-90);
    }
  
    public static void avoidDeadEnd() {
        pilot.travel(-60);
        pilot.rotate(180);
    }
}
