package com.siit.homework.course13.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Attendee {
    private TicketType ticketType;

    @Override
    public String toString() {
        return "Ticket type = " + ticketType;
    }
}
