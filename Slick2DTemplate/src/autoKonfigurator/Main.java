package autoKonfigurator;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Auto auto1 = new Auto(0, null, BodyDesign.Saloon, null, null);

        System.out.println("What brand of car do you want:");
        for (Brand c : Brand.values())
            System.out.println(c);
        String brand = scanner.nextLine();
        switch (brand) {
            case "Opel":
                auto1.setBrand(Brand.Opel);
                break;
            case "BMW":
                auto1.setBrand(Brand.BMW);
                break;
            case "Mercedes":
                auto1.setBrand(Brand.Mercedes);
                break;
            case "Audi":
                auto1.setBrand(Brand.Audi);
                break;
            case "Skoda":
                auto1.setBrand(Brand.Skoda);
                break;
            case "VW":
                auto1.setBrand(Brand.VW);
                break;
        }

        System.out.println("What kind of body design do you want:");
        for (BodyDesign c : BodyDesign.values())
            System.out.println(c);
        String bodyDesign = scanner.nextLine();
       switch (bodyDesign){
           case "Convertible":
               auto1.setBodyDesign(BodyDesign.Convertible);
               break;
           case "Coupe":
               auto1.setBodyDesign(BodyDesign.Coupe);
               break;
           case "Compact":
               auto1.setBodyDesign(BodyDesign.Compact);
               break;
           case "Saloon":
               auto1.setBodyDesign(BodyDesign.Saloon);
               break;
           case "Estate":
               auto1.setBodyDesign(BodyDesign.Estate);
               break;
           case "SUV":
               auto1.setBodyDesign(BodyDesign.SUV);
               break;

       }

        System.out.println("Chose the gearbox which you want:");
        for (Gearbox c : Gearbox.values())
            System.out.println(c);
        String gearBox = scanner.nextLine();
        switch (gearBox) {
            case "Automatic":
                auto1.setGearbox(Gearbox.Automatic);
                break;
            case "Semiautomatic":
                auto1.setGearbox(Gearbox.Semiautomatic);
                break;
            case "Manual":
                auto1.setGearbox(Gearbox.Manual);
                break;
        }

        System.out.println("Please chose the type o fuel:");
        for (Fuel c : Fuel.values())
            System.out.println(c);
        String fuel = scanner.nextLine();
        switch (fuel) {
            case "DIESEL":
                auto1.setFuel(Fuel.DIESEL);
                break;
            case "ELECTRICITY":
                auto1.setFuel(Fuel.ELECTRICITY);
                break;
            case "GAS":
                auto1.setFuel(Fuel.GAS);
                break;
        }
        System.out.println("How many HP your car should have:");
        int ps = scanner.nextInt();
        auto1.setPS(ps);

        System.out.println(auto1.getBrand());
        String autobrand = auto1.getBrand().toString();
        System.out.println(auto1.getGearbox());
        String gearbox = auto1.getGearbox().toString();
        System.out.println(auto1.getFuel());
        String fuel2 = auto1.getFuel().toString();
        System.out.println(auto1.getBodyDesign());
        String design = auto1.getBodyDesign().toString();
        System.out.println(auto1.getPS());

        auto1.calculateVehiclePreis(auto1);
        int preis1 = (int) auto1.getPreis();


        File file = new File("C:\\Users\\DCV\\Desktop\\Car.txt");

        OutputStream outputStream = null;

        try {
            outputStream= new FileOutputStream(file);
            outputStream.write(autobrand.getBytes());
            outputStream.write(';');
            outputStream.write(gearBox.getBytes());
            outputStream.write(';');
            outputStream.write(fuel2.getBytes());
            outputStream.write(';');
            outputStream.write(design.getBytes());
            outputStream.write(';');
            outputStream.write(Integer.toString(preis1).getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
