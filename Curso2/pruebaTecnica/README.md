# ✈️ Prueba Técnica - Lista de Vuelos (Java) ✈️ 

## Descripción del ejercicio:

Este proyecto es parte de una **prueba técnica del bootcamp**. El objetivo era crear un programa en Java que gestione una lista de vuelos y permita filtrarlos según fechas.
Tenía que organizar bien el código y aplicar algunos conceptos como clases, paquetes y uso de fechas con `LocalDate`.

## Qué hace el programa??

- Muestra una lista de vuelos simulados (10 en total).
- Permite filtrar esos vuelos según:
  - Fecha de inicio (`fechaDesde`)
  - Fecha final (`fechaHasta`)
  - O ambas fechas a la vez.
- Si no se dan fechas, muestra todos los vuelos.
- Los vuelos siempre se muestran **ordenados por la fecha de salida**.

## 🗂️ Estructura del proyecto 🗂️

- `entities/Vuelo.java`: clase con los datos del vuelo (origen, destino, empresa, fechas, etc.).
- `utils/FiltroVuelos.java`: clase con el método que filtra los vuelos según las fechas.
- `Main.java`: donde se inicializa todo, se crean los vuelos y se ejecutan los filtros.

## Fechas

Las fechas se trabajan como `LocalDate` y están dentro del año 2025, como pedía el ejercicio, también quise añadir un apartado de 2024, para variar un poco. Se definieron al principio de `Main` como constantes para hacer pruebas más fácil.

## Cómo ejecutar el programa▶️▶️ 

1. Abre el proyecto con **IntelliJ IDEA**.
2. Asegúrate de que tienes configurado un JDK (Java 17 o superior).
3. Ejecuta `Main.java` (clic derecho → Run).
4. Se mostrará el resultado del filtro directamente en la terminal.

## Qué aprendí 🤔

- Aprendí a usar `LocalDate` en Java.
- Me costó un poco al principio entender cómo aplicar los filtros correctamente con `Streams`, pero después de varios intentos logré que funcionara bien.
- Me ayudó a entender cómo separar mejor las clases en paquetes (`entities` y `utils`), algo que no había hecho tanto antes.

---

👨‍🎓 **Alumno**: *Jesús Partal Rueda*  
📅 **Fecha**: *26/05/2025*
