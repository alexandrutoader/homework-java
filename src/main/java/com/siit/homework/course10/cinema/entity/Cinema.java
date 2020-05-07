package com.siit.homework.course10.cinema.entity;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Cinema {
    private String name;
    private Map<Integer, Seat[]>seats;

    @Builder
    public Cinema(String name, Map<Integer, Seat[]> seats) {
        this.name = name;
        this.seats = seats;
    }

    public Cinema() {
    }
}
