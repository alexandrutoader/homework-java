package com.siit.homework.course13.service;

import com.siit.homework.course13.entity.FestivalAttendeeThread;
import com.siit.homework.course13.entity.FestivalGate;
import com.siit.homework.course13.entity.TicketType;

import java.util.ArrayList;

public class FestivalService {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<FestivalGate> festivalGates = new ArrayList<>();

        FestivalGate gate1 = new FestivalGate();
        gate1.setGate("A1");
        FestivalGate gate2 = new FestivalGate();
        gate2.setGate("A2");
        FestivalGate gate3 = new FestivalGate();
        gate3.setGate("A3");
        FestivalGate gate4 = new FestivalGate();
        gate4.setGate("A4");

        festivalGates.add(gate1);
        festivalGates.add(gate2);
        festivalGates.add(gate3);
        festivalGates.add(gate4);

        TicketType[] tickets = TicketType.values();
        FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(tickets, festivalGates.get(1));
        festivalAttendee.validate();
    }
}
