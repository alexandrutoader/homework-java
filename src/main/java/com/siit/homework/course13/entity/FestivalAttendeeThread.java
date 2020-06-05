package com.siit.homework.course13.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class FestivalAttendeeThread extends Thread {
    private FestivalGate gate;

    public void run() {
        Attendee attendee = new Attendee(TicketType.randomTicketType());
        gate.newAttendee(attendee);
        System.out.println(attendee);
    }
}
