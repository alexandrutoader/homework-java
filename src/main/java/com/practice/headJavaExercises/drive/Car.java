package com.practice.headJavaExercises.drive;

public class Car {
    private int yearModel;
    private String manufacturerModel;
    private int priceModel;
    private int kilometers;
    private int speed;

    public static void main(String[] args) {

    }

    public void car (String manufacturer, int year, int km, int price) {
        yearModel = year;
        manufacturerModel = manufacturer;
        priceModel = price;
        kilometers = km;
    }

    public int getYearModel() {
        return yearModel;
    }

    public void setYearModel(int yearModel) {
        this.yearModel = yearModel;
    }

    public String getManufacturerModel() {
        return manufacturerModel;
    }

    public void setManufacturerModel(String manufacturerModel) {
        this.manufacturerModel = manufacturerModel;
    }

    public int getPriceModel() {
        return priceModel;
    }

    public void setPriceModel(int priceModel) {
        this.priceModel = priceModel;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
