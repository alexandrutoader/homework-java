package com.siit.homework.course13.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;

@Setter
@Getter
public class FestivalGate {
    private int fullPass;
    private int fullVipPass;
    private int freePass;
    private int oneDayPass;
    private int oneDayVipPass;

    Queue<Attendee> gateQueue = new LinkedList<>();

    public synchronized void newAttendee(Attendee attendee) {
        gateQueue.add(attendee);
    }

    private int calculateSumOfEntries() {
        return fullPass + freePass + fullVipPass + oneDayVipPass + oneDayPass;
    }

    public synchronized void incrementGateStatisticsForGivenTicketType() {
        for (int i = 0; i <= gateQueue.size(); i++) {

            switch (gateQueue.poll().getTicketType()) {
                case FULL:
                    fullPass++;
                    break;
                case FULL_VIP:
                    fullVipPass++;
                    break;
                case FREE_PASS:
                    freePass++;
                    break;
                case ONE_DAY:
                    oneDayPass++;
                    break;
                case ONE_DAY_VIP:
                    oneDayVipPass++;
                    break;
                default:
                    break;
            }
        }

        System.out.println("\n========================================================");
        System.out.println(calculateSumOfEntries() + " people have entered");
        System.out.println(fullPass + " have full passes");
        System.out.println(freePass + " have free passes");
        System.out.println(fullVipPass + " have full VIP passes");
        System.out.println(oneDayPass + " have one day passes");
        System.out.println(oneDayVipPass + " have one day VIP passes");
        System.out.println("========================================================\n");
    }
}
