package com.siit.homework.course10.cinema.entity;

import lombok.*;

import java.math.BigDecimal;

@Builder
@EqualsAndHashCode
@Getter
@Setter
public class Seat {
    private String seatNumber;
    private String seatRow;
    private boolean reserved;
    private BigDecimal price;

    public Seat(String seatNumber, String seatRow, boolean reserved, BigDecimal price) {
        this.seatNumber = seatNumber;
        this.seatRow = seatRow;
        this.reserved = reserved;
        this.price = price;
    }

    public Seat() {
    }

    public String toString() {
        if (reserved) {
            return seatRow + seatNumber;
        } else {
            return "X";
        }
    }
}
