package com.siit.homework.course13.entity;

import java.io.Serializable;
import java.util.*;

public enum TicketType implements Serializable {
    FULL,
    FULL_VIP,
    FREE_PASS,
    ONE_DAY,
    ONE_DAY_VIP;

    private static final List<TicketType> ticketList =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int size = ticketList.size();
    private static final Random randomTicketValueFromListSize = new Random();

    public static TicketType randomTicketType() {
        return ticketList.get(randomTicketValueFromListSize.nextInt(size));
    }
}
