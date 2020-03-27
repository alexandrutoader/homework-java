package com.siit.homework.Course5.bank.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Card {
    private String expirationDate;
    private String ownerName;
    private long cardNumber;
    private Integer pinCode;


    public Card(String expirationDate, String ownerName, long cardNumber, Integer pinCode) {
        this.expirationDate = expirationDate;
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
    }

    public Card() {
    }

    public void addCard(String expirationDate, String ownerName, long cardNumber, Integer pinCode) {
        this.expirationDate = expirationDate;
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
    }
}
