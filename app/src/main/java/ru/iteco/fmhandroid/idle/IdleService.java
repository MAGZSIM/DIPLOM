package ru.iteco.fmhandroid.idle;

import androidx.test.espresso.idling.CountingIdlingResource;

public class IdleService {
    private static final String TAG = "IDLE";
    public static CountingIdlingResource idleCounter = new CountingIdlingResource(TAG);

    public static void incr(){
        idleCounter.increment();
    }

    public static void decr(){
        if (!idleCounter.isIdleNow()){
            idleCounter.decrement();
        }
    }
}