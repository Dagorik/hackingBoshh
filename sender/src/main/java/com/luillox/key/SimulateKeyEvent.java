package com.luillox.key;

import com.bezirk.middleware.messages.Event;

/**
 * Created by Dagorik on 11/03/17.
 */

public class SimulateKeyEvent extends Event {
    private final int keyIntegerCode; //The integer code for the keystroke

    public SimulateKeyEvent(int keyIntegerCode) {
        this.keyIntegerCode = keyIntegerCode;
    }

    public int getKeyIntegerCode() {
        return keyIntegerCode;
    }
}
