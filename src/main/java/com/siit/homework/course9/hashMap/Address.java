package com.siit.homework.course9.hashMap;

public class Address {
    private String street;
    private int number;
    private String country;

    public Address(String street, int number, String country) {
        this.street = street;
        this.number = number;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public Address setNumber(int number) {
        this.number = number;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }
}
