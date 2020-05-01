package com.siit.homework.course9.hashMap;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {
    private String street;
    private int number;
    private String country;

    @Builder
    public Address(String street, int number, String country) {
        this.street = street;
        this.number = number;
        this.country = country;
    }
}
