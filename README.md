# Juego de Buscaminas en Consola

**Autoras:** Angelina Mishell Maldonado Toral, Adriana Paola Jurado Jiménez
**Materia:** Programación Orientada a Objetos
**Universidad:** Universidad Politécnica Salesiana

## Desarrollo e Implementación

En este proyecto se desarrolló el clásico juego de Buscaminas aplicando principios de diseño de software, código limpio y el patrón arquitectónico MVC:

* **Patrón Arquitectónico MVC:** El sistema se segmentó de forma estricta en tres capas independientes: Modelo (lógica del tablero y las casillas), Vista (interfaz interactiva en la consola) y Controlador (coordinación de turnos, victorias y derrotas).
* **Herencia y Polimorfismo:** Se implementó una estructura de herencia a partir de la clase abstracta `Casilla`, de la cual derivan las subclases `CasillaSegura` y `CasillaMina`. El polimorfismo se aplica mediante la interfaz `IDescubrible`, permitiendo que cada tipo de casilla reaccione de forma independiente al ser revelada.
* **Manejo de Archivos (Persistencia Binaria):** Se implementó la persistencia de datos mediante la serialización de objetos hacia el archivo físico `partida.dat` utilizando la clase auxiliar `GestorArchivos`, lo que permite guardar y continuar la partida.
* **Manejo de Excepciones:** Se aplicó un control robusto de errores creando la excepción de negocio `CasillaYaDescubiertaException` para evitar que el sistema colapse si el usuario interactúa incorrectamente con celdas ya reveladas.
* **Pruebas Unitarias y TDD:** Se diseñó una suite de pruebas automatizadas con JUnit 5 para validar de forma aislada el comportamiento lógico de las casillas, la distribución de minas y los métodos del tablero.

## Estructura del Código

El proyecto está organizado en paquetes dentro de Eclipse de la siguiente manera:

* **`src/modelo/`**: Clases de negocio puras (`Casilla`, `CasillaMina`, `CasillaSegura`, `Tablero`, `IDescubrible`).
* **`src/vista/`**: Clase `VistaConsola`, encargada de desplegar los menús interactivos, dibujar la matriz y dar formato visual a la salida de datos.
* **`src/controlador/`**: Clases `JuegoControlador` y `Main`, que actúan como mediadoras coordinando las acciones de la vista y mutando el modelo o invocando la persistencia.
* **`src/persistencia/`**: Clase `GestorArchivos`, responsable del manejo técnico de archivos binarios y flujos de entrada/salida.
* **`src/excepciones/`**: Clase `CasillaYaDescubiertaException` para interceptar violaciones a las reglas del juego.
* **`test/modelo/`**: Suite de pruebas unitarias con JUnit 5 (`CasillaMinaTest`, `CasillaSeguraTest`, `CasillaTest`, `TableroTest`).
* **`partida.dat`**: Archivo de datos binario ubicado en la raíz que actúa como almacén del estado guardado.

## Cómo ejecutar las pruebas unitarias

En Eclipse, despliega la carpeta fuente `test` en el Package Explorer. Haz clic derecho sobre el paquete o la carpeta `test`. Selecciona **Run As -> JUnit Test**. Se abrirá la pestaña de JUnit mostrando las pruebas ejecutadas. La barra se mostrará en verde, confirmando el correcto funcionamiento de la lógica del modelo y sus reglas.

## Cómo clonar y ejecutar el proyecto

Clonar el repositorio desde la terminal:
`git clone https://github.com/Mishell-Maldonado/BuscaminasPOO.git`

Importar en Eclipse: Selecciona **File -> Import -> General -> Existing Projects into Workspace** y elige la carpeta del proyecto clonado. Asegúrate de añadir JUnit 5 al Build Path si el IDE lo solicita.

Ejecutar el sistema: Ejecuta la clase `Main.java` (ubicada en el paquete `controlador`) como una aplicación Java (**Run As -> Java Application**). Se desplegará el menú interactivo en la consola.
