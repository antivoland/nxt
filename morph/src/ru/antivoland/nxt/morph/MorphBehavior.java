package ru.antivoland.nxt.morph;

import lejos.nxt.Sound;
import lejos.robotics.Color;
import lejos.robotics.subsumption.Behavior;
import ru.antivoland.nxt.morph.state.MorphStateType;

/**
 * @author antivoland
 */
public class MorphBehavior implements Behavior{

    public MorphBehavior(Morph morph) {
        this.morph = morph;
    }

    public boolean takeControl() {
        return true;
    }

    public void action() {
        if (morph.getLeftHand().isPressed()) {
            System.exit(0);
        } else if (morph.getRightHand().isPressed()) {
            Sound.beep();
        } else if (morph.getSonar().ping() == 0) {
            if (morph.getSonar().getDistance() < 30) {
                //morph.getLeftMotor().rotate(-180, true);
                morph.getRightMotor().rotate(-360);
                Sound.beep();
            }
        } else if (morph.getLight().getColorID() == Color.BLUE) {
            Sound.beepSequence();
        }
    }

    public void suppress() {
        // do nothing
    }

    private Morph morph;

}
