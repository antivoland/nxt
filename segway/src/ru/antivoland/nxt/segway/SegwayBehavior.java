/*
 * @author antivoland
 */
package ru.antivoland.nxt.segway;

import lejos.nxt.Sound;
import lejos.robotics.subsumption.Behavior;

public class SegwayBehavior implements Behavior{

    public SegwayBehavior(Segway segway) {
        this.segway = segway;
    }

    public boolean takeControl() {
        return true;
    }

    public void action() {
        if (segway.getLeftHand().isPressed()) {
            System.exit(0);
        } else if (segway.getRightHand().isPressed()) {
            // Sound.beep();
            Sound.beepSequence();
            // segway.getLight().setFloodlight(0xFF0000);
            segway.getBodyMotor().rotate(-15);
        }
    }

    public void suppress() {
        // do nothing
    }

    private Segway segway;

}
