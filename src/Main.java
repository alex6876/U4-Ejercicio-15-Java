import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<VehiculoCarrera> vehiculos = new ArrayList<>();

        vehiculos.add(new MonoplazaF1("Ferrari F1", 100));
        vehiculos.add(new AutoRally("Subaru Rally", 100));
        vehiculos.add(new Motocicleta("Ducati", 100));

        ControlCarrera control = new ControlCarrera();

        control.ejecutarPruebas(vehiculos, 5);
    }
}