package com.siit.homework.course13.entity;

public class FestivalStatisticsThread extends Thread {
    private FestivalGate gate;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        try {
            currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        while (gate.gateQueue.size() != 0) {
            System.out.println("Ticket statistics at current point");
            gate.incrementGateStatisticsForGivenTicketType();
            try {
                currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
    }
}
