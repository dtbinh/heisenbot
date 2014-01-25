package heisenbot;

import lejos.nxt.Motor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;

public class RobotConfig {
        
        static RegulatedMotor left = Motor.B;
        static RegulatedMotor right = Motor.C;
        static DifferentialPilot pilot = new DifferentialPilot(56, 165, left, right);
        
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
        
        public static void revLeft() {
            pilot.travel(-60);
            pilot.rotate(90);
        }
        
        public static void turnLeft() {
            pilot.rotate(90);
        }
        
        public static void turnRight() {
            pilot.rotate(-90);
        }
        
        public static void exploreLeft() {
            pilot.travel(30);
        	pilot.rotate(75);
        }
        
        public static void exploreRight() {
            pilot.travel(30);
        	pilot.rotate(-75);
        }
        
        public static void avoidObstacelRight() {
                pilot.travel(-60);
                pilot.rotate(-90);
        }
        
        public static void revRight() {
            pilot.travel(-60);
            pilot.rotate(-90);
        }
        
        public static void avoidDeadEnd() {
                pilot.travel(-60);
                pilot.travel(180);
        }
}
