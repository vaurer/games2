package autoKonfigurator;

public class Main {
    public static void main(String[] args) {
        Auto auto1 = new Auto(120, Fuel.DIESEL, BodyDesign.Coupe, Gearbox.Automatic, Brand.Audi);
        auto1.calculateVehiclePreis(auto1);
        System.out.println(auto1.getPreis());
    }


}
