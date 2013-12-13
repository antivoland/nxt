/*
* @author antivoland
*/
package ru.antivoland.nxt.segway;

import java.io.File;

import lejos.nxt.*;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Segway {

    public RegulatedMotor getLeftMotor() {
        return leftMotor;
    }

    public RegulatedMotor getRightMotor() {
        return rightMotor;
    }

    public RegulatedMotor getBodyMotor() {
        return bodyMotor;
    }

    public TouchSensor getLeftHand() {
        return leftHand;
    }

    public TouchSensor getRightHand() {
        return rightHand;
    }

    public ColorSensor getLight() {
        return light;
    }

    public UltrasonicSensor getSonar() {
        return sonar;
    }

    public void run() {
        Behavior[] behaviors = {new SegwayBehavior(this)};
        Arbitrator arbitrator = new Arbitrator(behaviors);
        arbitrator.start();
    }

    private RegulatedMotor leftMotor = Motor.C;
    private RegulatedMotor rightMotor = Motor.A;
    private RegulatedMotor bodyMotor = Motor.B;
    private TouchSensor leftHand = new TouchSensor(SensorPort.S4);
    private TouchSensor rightHand = new TouchSensor(SensorPort.S3);
    private ColorSensor light = new ColorSensor(SensorPort.S1);
    private UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S2);

    public static void main(String[] args) {
        System.out.println("APP STARTED");
        new Segway().run();
    }

}
