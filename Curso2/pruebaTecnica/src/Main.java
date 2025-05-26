import Entities.Vuelo;
import Utils.FiltroVuelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // Las constantes de fecha para filtrar (pueden ser también null):
    public static final LocalDate FECHA_DESDE = LocalDate.of(2024, 1, 1);
    public static final LocalDate FECHA_HASTA = LocalDate.of(2025, 12, 31);


    public static void main(String[] args) {
        // 1) Crear lista de vuelos:
        List<Vuelo> vuelos = crearVuelosDePrueba();

        // 2) Filtrar vuelos según las fechas dadas por el supuesto usuario:
        List<Vuelo> vuelosFiltrados = FiltroVuelos.filtrarVuelos(vuelos, FECHA_DESDE, FECHA_HASTA);

        // 3) Mostrar los vuelos filtrados en consola:
        System.out.println("La lista de los vuelos filtrados es: ");
        for (Vuelo v : vuelosFiltrados) {
            System.out.println(v);
        }
    }

    // Metodo que usaré para generar 10 vuelos ficticios en el año 2025:
    public static List<Vuelo> crearVuelosDePrueba() {
        List<Vuelo> lista = new ArrayList<>();

        lista.add(new Vuelo(1, "Vuelo1", "Iberia", "Madrid", "New York", LocalDate.of(2025, 3, 20), LocalDate.of(2025, 3, 21)));
        lista.add(new Vuelo(2, "Vuelo2", "Turkish", "Barcelona", "Estambul", LocalDate.of(2025, 11, 12), LocalDate.of(2025, 11, 13)));
        lista.add(new Vuelo(3, "Vuelo3", "Air France", "Paris", "Buenos Aires", LocalDate.of(2025, 5, 25), LocalDate.of(2025, 5, 27)));
        lista.add(new Vuelo(4, "Vuelo4", "Delta", "Madrid", "Miami", LocalDate.of(2025, 5, 28), LocalDate.of(2025, 5, 29)));
        lista.add(new Vuelo(5, "Vuelo5", "Vueling", "Berlin", "Madrid", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 2)));
        lista.add(new Vuelo(6, "Vuelo6", "United", "Chicago", "Barcelona", LocalDate.of(2024, 7, 3), LocalDate.of(2025, 7, 4)));
        lista.add(new Vuelo(7, "Vuelo7", "Ryanair", "Santiago", "Lima", LocalDate.of(2025, 6, 5), LocalDate.of(2025, 6, 6)));
        lista.add(new Vuelo(8, "Vuelo8", "Emirates", "Dubai", "New York", LocalDate.of(2024, 6, 10), LocalDate.of(2024, 6, 11)));
        lista.add(new Vuelo(9, "Vuelo9", "Qatar Airways", "Doha", "Barcelona", LocalDate.of(2025, 6, 15), LocalDate.of(2025, 6, 16)));
        lista.add(new Vuelo(10, "Vuelo10", "American Airlines", "Los Angeles", "Madrid", LocalDate.of(2025, 6, 20), LocalDate.of(2025, 6, 21)));

        return lista;
    }
}