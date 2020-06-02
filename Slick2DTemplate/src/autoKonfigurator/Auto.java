package autoKonfigurator;

import org.newdawn.slick.tests.SoundTest;

public class Auto {

    public Auto(int PS, Fuel fuel, BodyDesign bodyDesign, Gearbox gearbox, Brand brand) {
        this.PS = PS;
        this.fuel = fuel;
        this.bodyDesign = bodyDesign;
        this.gearbox = gearbox;
        this.brand = brand;
        this.preis = 0;
    }

    public int getPS() {
        return PS;
    }

    public void setPS(int PS) {
        this.PS = PS;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public BodyDesign getBodyDesign() {
        return bodyDesign;
    }

    public void setBodyDesign(BodyDesign bodyDesign) {
        this.bodyDesign = bodyDesign;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    int PS;
    double preis = 0;
    Fuel fuel;
    BodyDesign bodyDesign;
    Gearbox gearbox;
    Brand brand;

    public double calculateVehiclePreis(Auto auto) {
        double preis = 0;
        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;
        switch (gearbox) {
            case Manual:
                a = a;
                break;
            case Semiautomatic:
                a = 1500;
                break;
            case Automatic:
                a = 2500;
                break;
        }
        switch (fuel) {
            case GAS:
                b = b;
                break;
            case DIESEL:
                b = 3000;
                break;
            case ELECTRICITY:
                b = 4000;
        }
        switch (bodyDesign) {
            case Compact:
                c = c;
                break;
            case Saloon:
                c = 7000;
                break;
            case Estate:
                c = 8500;
                break;
            case Coupe:
                c = 11000;
                break;
            case SUV:
                c = 15000;
                break;
        }
        switch (brand) {
            case Opel:
                d = 1;
                break;
            case Skoda:
                d = 1.2;
                break;
            case VW:
                d = 1.45;
                break;
            case Audi:
                d = 1.9;
                break;
            case BMW:
                d = 2.2;
                break;
            case Mercedes:
                d = 2.7;
        }
        preis = (a * d) + (b * d) + (c * d);
        this.preis = preis;
        System.out.println(this.brand.name() + " ist " + this.preis + " wert");
        return preis;
    }
}
