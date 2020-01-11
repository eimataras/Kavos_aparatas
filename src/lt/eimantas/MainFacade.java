package lt.eimantas;

import model.Kava;
import model.Machine;

import java.util.Scanner;

public class MainFacade {

    public static void main(String[] args) {
        // write your code here
        Machine kavosAparatas = new Machine(0f, 0f, 0f, 0);


        Scanner sc = new Scanner(System.in);
        Integer baigtiDarba = 1;
        do {
            System.out.println("|--------------------------------------------|");
            System.out.println("|  Pasirinkite is MENIU ka norite daryti:    |");
            System.out.println("|--------------------------------------------|");
            System.out.println("|1|- Papildyti vandens/ pupeliu/ cukraus.    |");
            System.out.println("|2|- Atlikti plovima.                        |");
            System.out.println("|3|- Ar aparatas pasiruoses aptarnavimui?    |");
            System.out.println("|4|- Aparato busena (info)                   |");
            System.out.println("|5|-      ------- ESPRESSO --------          |");
            System.out.println("|6|-      ------ JUODA KAVA -------          |");
            System.out.println("|7|-      ---- JUODA BE CUKRAUS ---          |");
            System.out.println("|0|- BAIGTI DARBA                            |");
            System.out.println("|--------------------------------------------|");
            Integer meniu = sc.nextInt();

            switch (meniu) {
                case 0: {
                    baigtiDarba = 0;
                    break;
                }
                case 1: {
                    System.out.println("1 - Papildyti vandens.\n2 - Papildyti pupeliu.\n3 - Papildyti cukraus.");
                    Integer pildoMeniu = sc.nextInt();
                    switch (pildoMeniu) {
                        case 1: {
                            kavosAparatas.topUpWater();
                            System.out.println("-------------------------------------------");
                            System.out.println(kavosAparatas);
                            System.out.println("-------------------------------------------");
                            break;
                        }
                        case 2: {
                            kavosAparatas.topUpCoffee();
                            System.out.println("-------------------------------------------");
                            System.out.println(kavosAparatas);
                            System.out.println("-------------------------------------------");
                            break;
                        }
                        case 3: {
                            kavosAparatas.topUpSugar();
                            System.out.println("-------------------------------------------");
                            System.out.println(kavosAparatas);
                            System.out.println("-------------------------------------------");
                            break;
                        }
                        default: {
                            System.out.println("Tokio pasirinkimo nera");
                        }
                    }
                    break;
                }
                case 2: {
                    kavosAparatas.getFlushed();
                    System.out.println("Liko iki plovimo: "+kavosAparatas.drinksLeftTillFlush());
                    break;
                }
                case 3: {
                    if (kavosAparatas.ifReady(5f, 200f, 20f)) {
                        System.out.println("Kavos aparatas yra pasiruoses");
                    } else {
                        System.out.println("Kavos aparatui reikalingas servisas");
                    }
                    break;
                }
                case 4: {
                    System.out.println(kavosAparatas);
                    break;
                }
                case 5: {
                    String name = "Kava Espresso";
                    Float sugar = 5f;
                    Float water = 200f;
                    Float coffee = 20f;
                    Kava espresso = new Kava(name, sugar, water, coffee);
                    kavosAparatas.makeCoffee(espresso.getName(), espresso.getSugar(), espresso.getWater(), espresso.getCoffee());
                    System.out.println("-------------------------------------------");
                    System.out.println(kavosAparatas);
                    System.out.println("-------------------------------------------");
                    break;
                }
                case 6: {
                    String name = "Juoda kava";
                    Float sugar = 5f;
                    Float water = 200f;
                    Float coffee = 10f;
                    Kava juoda = new Kava(name, sugar, water, coffee);
                    kavosAparatas.makeCoffee(juoda.getName(), juoda.getSugar(), juoda.getWater(), juoda.getCoffee());
                    System.out.println("-------------------------------------------");
                    System.out.println(kavosAparatas);
                    System.out.println("-------------------------------------------");
                    break;
                }
                case 7: {
                    String name = "Juoda kava be cukraus";
                    Float sugar = 0f;
                    Float water = 200f;
                    Float coffee = 10f;
                    Kava beCukraus = new Kava(name, sugar, water, coffee);
                    kavosAparatas.makeCoffee(beCukraus.getName(), beCukraus.getSugar(), beCukraus.getWater(), beCukraus.getCoffee());
                    System.out.println("-------------------------------------------");
                    System.out.println(kavosAparatas);
                    System.out.println("-------------------------------------------");
                    break;
                }
                default: {
                    System.out.println("Tokio pasirinkimo nera.");
                    break;
                }
            }
        } while (baigtiDarba != 0);
    }
}
