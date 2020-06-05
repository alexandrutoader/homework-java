package com.siit.homework.course13.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
@AllArgsConstructor
public class FestivalAttendeeThread extends Thread {
    private TicketType[] ticketType;
    private FestivalGate gate;

    public void validate() {
        Thread person = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                Thread.currentThread().setName(randomTicketType().toString());
                System.out.println("gg" + " " + Thread.currentThread().getName() + ": " + i);
            }
        });
        person.setDaemon(true);
        person.start();

        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
//            Thread.sleep(10);
        }
    }

    private static TicketType randomTicketType() {
        int pick = new Random().nextInt(TicketType.values().length);
        return TicketType.values()[pick];
    }
}
