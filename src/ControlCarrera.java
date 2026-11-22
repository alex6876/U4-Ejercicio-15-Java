import java.util.List;

public class ControlCarrera {

    public void ejecutarPruebas(List<VehiculoCarrera> vehiculos, int segundos) {

        for (VehiculoCarrera vehiculo : vehiculos) {

            vehiculo.acelerar(segundos);

            System.out.println("Vehiculo: " + vehiculo.getNombre());
            System.out.println("Velocidad actual: " +
                    vehiculo.getVelocidadActual() + " km/h");

            System.out.println("Combustible restante: " +
                    vehiculo.getCombustible());

            System.out.println("Desempeno: " +
                    vehiculo.obtenerDesempeno());

            System.out.println("-------------------------");
        }
    }
}