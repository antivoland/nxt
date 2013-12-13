package ru.antivoland.nxt.morph.state;

import ru.antivoland.nxt.morph.Morph;

/**
 * @author antivoland
 */
public class DestroyState extends MorphState {

    public DestroyState(MorphStateType type, Morph morph) {
        super(type, morph);
    }

    @Override
    public void enter() {
        System.exit(0);
    }

}
