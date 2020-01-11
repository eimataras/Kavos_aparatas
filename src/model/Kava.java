package model;

public class Kava {

    private String name;
    private Float sugar;
    private Float water;
    private Float coffee;


    public Kava(String parName, Float parSugar, Float parWater, Float parCoffee) {
        this.name = parName;
        this.sugar = parSugar;
        this.water = parWater;
        this.coffee = parCoffee;
    }

    public String getName() {
        return name;
    }

    public Float getCoffee() {
        return coffee;
    }

    public Float getWater() {
        return water;
    }

    public Float getSugar() {
        return sugar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoffee(Float coffee) {
        this.coffee = coffee;
    }

    public void setSugar(Float sugar) {
        this.sugar = sugar;
    }

    public void setWater(Float water) {
        this.water = water;
    }
}
