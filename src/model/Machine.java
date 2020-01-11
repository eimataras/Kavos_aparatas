package model;

import java.util.Scanner;

public class Machine {

    private static Integer MAX_USE_NO = 50;
    private static Float MAX_SUGAR_G = 1000f;
    private static Float MAX_WATER_ML = 3000f;
    private static Float MAX_COFFEE_G = 1000f;
    private Float sugar;
    private Float water;
    private Float coffee;
    private Integer useNo;

    public Machine() {
    }

    public Machine(Float parSugar, Float parWater, Float parCoffee) {
        this.sugar = parSugar;
        this.water = parWater;
        this.coffee = parCoffee;
    }

    public Machine(Float parSugar, Float parWater, Float parCoffee, Integer parUseNo) {
        this.sugar = parSugar;
        this.water = parWater;
        this.coffee = parCoffee;
        this.useNo = parUseNo;
    }


    public void makeCoffee(String vardas, Float cukrus, Float vanduo, Float kava) {
        if (sugar < cukrus) {
            System.out.println("Papildykite cukraus!");
        } else if (water < vanduo) {
            System.out.println("Papildykite vandens!");
        } else if (coffee < kava) {
            System.out.println("Papildykite kavos pupeliu!");
        } else if (useNo >= MAX_USE_NO) {
            System.out.println("Isplaukite aparata!");
        } else {
            sugar = sugar - cukrus;
            water = water - vanduo;
            coffee = coffee - kava;
            useNo++;
            System.out.println("Jusu "+vardas+" paruosta. Skanaus :-)");
        }
    }

    public void topUpSugar() {
        Scanner sc = new Scanner(System.in);
        Float kiekis;
        Float pildytMax = MAX_SUGAR_G - sugar;
        do {
            System.out.println("Kiek gramu cukraus pilate? Iki pilno truksta: " + pildytMax + " g.");
            kiekis = sc.nextFloat();
            if (kiekis <= pildytMax) {
                sugar = sugar + kiekis;
                System.out.println("Papildete sekmingai. Siuo metu aparate yra: " + sugar + " g cukraus");
            } else {
                System.out.println("Tiek nebetelpa!");
            }
        } while (kiekis > pildytMax);
    }

    public void topUpWater() {
        Scanner sc = new Scanner(System.in);
        Float kiekis;
        Float pildytMax = MAX_WATER_ML - water;
        do {
            System.out.println("Kiek ml vandens pilate? Iki pilno truksta: " + pildytMax + " ml.");
            kiekis = sc.nextFloat();
            if (kiekis <= pildytMax) {
                water = water + kiekis;
                System.out.println("Papildete sekmingai. Siuo metu aparate yra: " + water + " ml vandens");
            } else {
                System.out.println("Tiek nebetelpa!");
            }
        } while (kiekis > pildytMax);
    }//Analogiskas

    public void topUpCoffee() {
        Scanner sc = new Scanner(System.in);
        Float kiekis;
        Float pildytMax = MAX_COFFEE_G - coffee;
        do {
            System.out.println("Kiek g kavos pupeliu pilate? Iki pilno truksta: " + pildytMax + " g.");
            kiekis = sc.nextFloat();
            if (kiekis <= pildytMax) {
                coffee = coffee + kiekis;
                System.out.println("Papildete sekmingai. Siuo metu aparate yra: " + coffee + " g kavos pupeliu");
            } else {
                System.out.println("Tiek nebetelpa!");
            }
        } while (kiekis > pildytMax);
    } //Analogiskas

    public Boolean ifReady(Float maxCukrus, Float maxVanduo, Float maxKava) {
        Boolean result = false;
        if (useNo < MAX_USE_NO && sugar > maxCukrus && water > maxVanduo && coffee > maxKava) {
            result = true;
        }
        return result;
    }

    public void getFlushed() {
        useNo = 0;
        System.out.println("Aparatas sekmingai isplautas.");
    }

    public Integer drinksLeftTillFlush() {
        return MAX_USE_NO - useNo;
    }

    @Override
    public String toString() {
        return "Cukraus kiekis (g): " + sugar + ";\nVandens kiekis (ml): " + water + ";\nKavos pupeliu kiekis (g): " + coffee + ";\nIki plovimo liko: " + drinksLeftTillFlush() + " kavos(u)";
    }
}
