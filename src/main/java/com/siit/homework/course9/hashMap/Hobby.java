package com.siit.homework.course9.hashMap;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Hobby {
    private int frequency;
    private String name;
    private List<Address> addresses;

    @Builder
    public Hobby(int frequency, String name, List<Address> addresses) {
        this.frequency = frequency;
        this.name = name;
        this.addresses = addresses;
    }
}
