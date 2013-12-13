package ru.antivoland.nxt.morph.state;

import lejos.nxt.Sound;
import ru.antivoland.nxt.morph.Morph;

/**
 * @author antivoland
 */
public class IdleState extends MorphState {

    public IdleState(MorphStateType type, Morph morph) {
        super(type, morph);
    }

    @Override
    public void enter() {
        getMorph().getBodyMotor().rotate(-180);
        getMorph().getLeftMotor().setSpeed(1000);
        getMorph().getRightMotor().setSpeed(1000);
        getMorph().getLeftMotor().forward();
        getMorph().getRightMotor().forward();
    }

    @Override
    public void action() {
    }

    @Override
    public void exit() {
        super.exit();
        getMorph().getBodyMotor().rotate(180);
    }

}
