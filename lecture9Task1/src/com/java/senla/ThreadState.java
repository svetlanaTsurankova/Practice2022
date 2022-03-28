package com.java.senla;

import java.lang.Thread.State;

public class ThreadState {
    public static String state(State state) {
        if (state == State.NEW) {
            return "NEW";
        } else if (state == State.RUNNABLE) {
            return "RUNNABLE";
        } else if (state == State.BLOCKED) {
            return "BLOCKED";
        } else if (state == State.WAITING) {
            return "WAITING";
        } else if (state == State.TIMED_WAITING) {
            return "TIMED_WAITING";
        } else {
            return state == State.TERMINATED ? "TERMINATED" : null;
        }
    }
}
