package ru.antivoland.nxt.morph.state;

import ru.antivoland.nxt.morph.Morph;

/**
 * @author antivoland
 */
public class MorphState {

    public MorphStateType getType() {
        return type;
    }

    public Morph getMorph() {
        return morph;
    }

    public MorphState(MorphStateType type, Morph morph) {
        this.type = type;
        this.morph = morph;
    }

    public void enter() {
        // do nothing
    }

    public void action() {
        // do nothing
    }

    public void exit() {
        // do nothing
    }

    private MorphStateType type;
    private Morph morph;

    public static MorphState createState(MorphStateType type, Morph morph) {
        switch (type) {
            case IDLE:
                return new IdleState(type, morph);
            case DESTROY:
            default:
                return new DestroyState(type, morph);
        }
    }

}
