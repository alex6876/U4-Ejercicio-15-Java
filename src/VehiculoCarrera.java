public abstract class VehiculoCarrera {

    protected double velocidadActual;
    protected double combustible;
    protected double velocidadMaxima;
    protected String nombre;

    public VehiculoCarrera(String nombre, double combustible, double velocidadMaxima) {
        this.nombre = nombre;
        this.combustible = combustible;
        this.velocidadMaxima = velocidadMaxima;
        this.velocidadActual = 0;
    }

    public abstract void acelerar(int segundos);

    public abstract String obtenerDesempeno();

    protected void aplicarAceleracion(int segundos, double tasaAceleracion,
                                      double consumoPorSegundo) {

        if (segundos <= 0 || combustible <= 0) {
            System.out.println(nombre + ": no puede acelerar.");
            return;
        }

        double combustibleNecesario = segundos * consumoPorSegundo;


        double combustibleUtilizado = Math.min(combustible, combustibleNecesario);


        double tiempoReal = combustibleUtilizado / consumoPorSegundo;

        velocidadActual += tasaAceleracion * tiempoReal;

        if (velocidadActual > velocidadMaxima) {
            velocidadActual = velocidadMaxima;
        }

        combustible -= combustibleUtilizado;
    }

    public String getNombre() {
        return nombre;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    public double getCombustible() {
        return combustible;
    }
}