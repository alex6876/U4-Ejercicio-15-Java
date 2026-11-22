# Simulación de Pruebas de Rendimiento y Aceleración de Vehículos de Carrera (Clases Abstractas y Polimorfismo en Java)

Este proyecto es una aplicación en Java que modela un sistema de pruebas en pista para vehículos de competición, implementando una arquitectura basada en clases abstractas y herencia para administrar distintos tipos de máquinas (monoplazas de Fórmula 1, autos de rally y motocicletas) con parámetros diferenciados de velocidad máxima, tasa de aceleración, consumo de combustible por segundo y perfil de desempeño. Pone en práctica conceptos fundamentales de la Programación Orientada a Objetos (POO) como la generalización de atributos protegidos (`protected`), el uso de constructores mediante `super`, la combinación de métodos abstractos (`abstract`) con métodos auxiliares protegidos reutilizables (`aplicarAceleracion`), la sobrescritura polimórfica de comportamiento (`@Override`) y el procesamiento de colecciones en memoria sin persistencia en base de datos.

---

## Clases y Estructura del Sistema

El diseño del software se organiza a través de una clase base abstracta, sus respectivas subclases especializadas por categoría de competición, el componente de control de pista y el punto de ejecución:

* **`VehiculoCarrera` (Clase Abstracta)**: Centraliza el estado dinámico, los atributos compartidos y la mecánica base de aceleración y consumo de cualquier vehículo de carrera.
* **Atributos protegidos (`protected`)**: `velocidadActual`, `combustible`, `velocidadMaxima` y `nombre`, accesibles por las subclases para gestionar el estado de cada competidor.
* **Constructor**: Recibe `nombre`, `combustible` y `velocidadMaxima`, e inicializa `velocidadActual` en `0`.
* **Métodos operativos**:
* `abstract void acelerar(int segundos)`: Método abstracto que obliga a cada tipo de vehículo a definir sus propios parámetros de aceleración y consumo por segundo.
* `abstract String obtenerDesempeno()`: Método abstracto que exige a cada subclase informar su configuración de tracción y velocidad máxima.
* `aplicarAceleracion(int segundos, double tasaAceleracion, double consumoPorSegundo)`: Método protegido reutilizable que valida que haya tiempo y combustible disponibles, calcula el combustible utilizable y el tiempo efectivo de aceleración, incrementa `velocidadActual` respetando el tope de `velocidadMaxima` y descuenta el combustible consumido.
* `getNombre()` / `getVelocidadActual()` / `getCombustible()`: Métodos de acceso público para consultar de forma encapsulada el estado actual del vehículo.




* **`MonoplazaF1`**: Extiende de `VehiculoCarrera` para modelar un vehículo de Fórmula 1 con máxima velocidad punta y alta tasa de aceleración.
* **Constructor**: Invoca a `super(nombre, combustible, 350)` fijando su velocidad máxima en `350 km/h`.
* **Sobrescritura (`@Override`)**:
* `acelerar(int segundos)`: Delega en `aplicarAceleracion(segundos, 20, 2)` con una tasa de `20 km/h` por segundo y un consumo de `2` unidades por segundo.
* `obtenerDesempeno()`: Retorna `"Traccion: alta | Velocidad maxima: 350 km/h"`.




* **`AutoRally`**: Extiende de `VehiculoCarrera` para modelar un automóvil de rally con tracción integral y consumos moderados.
* **Constructor**: Invoca a `super(nombre, combustible, 250)` estableciendo un límite de `250 km/h`.
* **Sobrescritura (`@Override`)**:
* `acelerar(int segundos)`: Ejecuta `aplicarAceleracion(segundos, 12, 1.5)` con una aceleración de `12 km/h` por segundo y un gasto de `1.5` unidades por segundo.
* `obtenerDesempeno()`: Retorna `"Traccion: integral | Velocidad maxima: 250 km/h"`.




* **`Motocicleta`**: Extiende de `VehiculoCarrera` para modelar una motocicleta de competición con tracción trasera y agilidad intermedia.
* **Constructor**: Invoca a `super(nombre, combustible, 300)` definiendo una velocidad máxima de `300 km/h`.
* **Sobrescritura (`@Override`)**:
* `acelerar(int segundos)`: Llama a `aplicarAceleracion(segundos, 16, 1.2)` con una tasa de `16 km/h` por segundo y un consumo de `1.2` unidades por segundo.
* `obtenerDesempeno()`: Retorna `"Traccion: trasera | Velocidad maxima: 300 km/h"`.




* **`ControlCarrera`**: Componente controlador encargado de orquestar las pruebas sobre el conjunto de vehículos.
* **Método operativo**: `ejecutarPruebas(List<VehiculoCarrera> vehiculos, int segundos)`: Recorre la lista polimórfica de vehículos, invoca `acelerar(segundos)` en cada uno e imprime por consola el nombre, la velocidad actual, el combustible restante y el desempeño técnico.


* **`Main`**: Punto de entrada del programa. Crea una lista de `VehiculoCarrera` con instancias de `MonoplazaF1`, `AutoRally` y `Motocicleta` (cada una con `100` de combustible inicial), instancia `ControlCarrera` y ejecuta `ejecutarPruebas(vehiculos, 5)`.

---

## Reglas de Negocio y Control de Validación

1. **Contrato y Reutilización de Mecánica Base:** `VehiculoCarrera` impone los métodos abstractos `acelerar(int segundos)` y `obtenerDesempeno()`, mientras centraliza en `aplicarAceleracion(...)` la fórmula de aceleración y consumo para evitar duplicar lógica entre subclases.
2. **Control de Combustible y Velocidad Límite:** Si el tiempo ingresado es menor o igual a `0` o el combustible es menor o igual a `0`, la aceleración se cancela; si el combustible no alcanza para cubrir todo el intervalo, se calcula el tiempo real cubierto con el combustible disponible, y en todos los casos la velocidad actual nunca supera `velocidadMaxima`.
3. **Procesamiento Polimórfico en Memoria:** `ControlCarrera` opera sobre una lista tipada de `VehiculoCarrera`, resolviendo dinámicamente los parámetros de cada vehículo sin acoplarse a sus clases concretas.

---

## Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
Vehiculo: Ferrari F1
Velocidad actual: 100.0 km/h
Combustible restante: 90.0
Desempeno: Traccion: alta | Velocidad maxima: 350 km/h
-------------------------
Vehiculo: Subaru Rally
Velocidad actual: 60.0 km/h
Combustible restante: 92.5
Desempeno: Traccion: integral | Velocidad maxima: 250 km/h
-------------------------
Vehiculo: Ducati
Velocidad actual: 80.0 km/h
Combustible restante: 94.0
Desempeno: Traccion: trasera | Velocidad maxima: 300 km/h
-------------------------

```

---

## Conceptos de Programación Aplicados

* **Abstracción y Polimorfismo:** Definición de contratos en una clase abstracta (`VehiculoCarrera`) y sobrescritura de métodos (`@Override`) para simular comportamientos diferenciados de competencia.
* **Herencia y Reutilización de Código:** Uso de `super` en los constructores y de un método `protected` compartido (`aplicarAceleracion`) para centralizar la física básica del movimiento.
* **Separación de Responsabilidades:** División clara entre el modelo de cada vehículo, la ejecución de pruebas en `ControlCarrera` y la configuración del escenario inicial en `Main`.
