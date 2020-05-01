package com.siit.homework.course9.hashMap;

import java.util.List;

public class Hobby {
    private String hobby;
    private int frequency;
    private List<Address> addresses;

    public Hobby(String hobby, int frequency, List<Address> addresses) {
        this.hobby = hobby;
        this.frequency = frequency;
        this.addresses = addresses;
    }

    public String getHobby() {
        return hobby;
    }

    public Hobby setHobby(String hobby) {
        this.hobby = hobby;
        return this;
    }

    public int getFrequency() {
        return frequency;
    }

    public Hobby setFrequency(int frequency) {
        this.frequency = frequency;
        return this;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public Hobby setAddresses(List<Address> addresses) {
        this.addresses = addresses;
        return this;
    }
}
