package com.siit.homework.Course4.bank;

public class Card {
    private String expirationDate;
    private String ownerName;
    private long cardNumber;

    public Card(String expirationDate, String ownerName, long cardNumber) {
        this.expirationDate = expirationDate;
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }
}
