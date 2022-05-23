package com.example.carrentaljavafx;

import java.io.Serializable;

public class Car_Rental implements Serializable {
    private int id;
    private int price;
    private String name;
    private String model;
    private int day;
    private int month;
    private int year;
    private String rent;

    public Car_Rental(int id, int price, String name, String model) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.model = model;
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.rent = null;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRent() {
        return this.rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }
}
