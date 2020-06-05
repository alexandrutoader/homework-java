package com.siit.homework.course13.entity;

import java.util.Random;

public class MainThread extends Thread {
    @Override
    public void run() {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
        Thread t1 = new Thread(statsThread);
        t1.start();
        int numberOfAttendees = getRandomAttendeeNumber();

        for (int i = 0; i < numberOfAttendees; i++) {
            runNewAttendeeThread(gate);
        }
    }

    private static int getRandomAttendeeNumber() {
        Random r = new Random();
        return r.nextInt(50) + 100;
    }

    public void runNewAttendeeThread(FestivalGate gate) {
        FestivalAttendeeThread attendeeThread = new FestivalAttendeeThread(gate);
        Thread t = new Thread(attendeeThread);

        t.start();
        try {
            t.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
