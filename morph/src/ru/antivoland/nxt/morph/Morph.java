package ru.antivoland.nxt.morph;

import lejos.nxt.*;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import ru.antivoland.nxt.morph.state.MorphState;
import ru.antivoland.nxt.morph.state.MorphStateType;

/**
 * @author antivoland
 */
public class Morph {

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

    public void setState(MorphStateType type) {
        if (this.state != null) {
            this.state.exit();
        }
        this.state = MorphState.createState(type, this);
        this.state.enter();
    }

    public void run() {
        setState(MorphStateType.IDLE);

        Behavior[] behaviors = {new MorphBehavior(this)};
        Arbitrator arbitrator = new Arbitrator(behaviors);
        arbitrator.start();
    }

    private RegulatedMotor leftMotor = Motor.C;
    private RegulatedMotor rightMotor = Motor.A;
    private RegulatedMotor bodyMotor = Motor.B;
    private TouchSensor leftHand = new TouchSensor(SensorPort.S3);
    private TouchSensor rightHand = new TouchSensor(SensorPort.S1);
    private ColorSensor light = new ColorSensor(SensorPort.S2);
    private UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S4);
    private MorphState state;

    public static void main(String[] args) throws Exception {
        new Morph().run();
    }

}
