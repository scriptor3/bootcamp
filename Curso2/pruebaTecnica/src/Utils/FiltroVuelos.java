package Utils;

import Entities.Vuelo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

// Esta clase utilitaria sirve para filtrar los diferentes vuelos por fechas:
public class FiltroVuelos {

    //Usaremos un metodo estático para filtrar según las condiciones dadas del supuesto usuario:
    public static List<Vuelo> filtrarVuelos(List<Vuelo> vuelos, LocalDate fechaDesde, LocalDate fechaHasta) {
        return vuelos.stream()
                .filter(vuelo -> {
                    // 1) Ambos filtros aplicados: DESDE y HASTA:
                    if (fechaDesde != null && fechaHasta != null) {
                        return !vuelo.getFechaInicio().isBefore(fechaDesde) && !vuelo.getFechaInicio().isAfter(fechaHasta);
                    }

                    // 2) Solo el filtro DESDE:
                    else if (fechaDesde != null) {
                        return !vuelo.getFechaInicio().isBefore(fechaDesde);
                    }

                    // Solo el filtro HASTA:
                    else if (fechaHasta != null) {
                        return !vuelo.getFechaInicio().isAfter(fechaHasta);
                    }

                    // Sin filtros (MOSTRAR TODOS):
                    else {
                        return true;
                    }
                })

                // Para ordenar por fecha de inicio utilizamos:
                .sorted((v1, v2) -> v1.getFechaInicio().compareTo(v2.getFechaInicio()))
                .collect(Collectors.toList());
    }
}