package com.example.myapplication;

public class DataModal {

    private String Power;
    private String Name;
    public DataModal(String Power, String Name){
        this.Power = Power;
        this.Name = Name;
    }

    public String getPower() {
        return Power;
    }

    public void setPower(String power) {
        Power = power;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
