package Entities;

import java.time.LocalDate;

// Esta clase representa un VUELO con sus correspondientes atributos
public class Vuelo {
    private int id;
    private String nombreVuelo;
    private String empresa;
    private String lugarSalida;
    private String lugarLlegada;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;


    // 1. Constructores de las variables:
    public Vuelo(int id, String nombreVuelo, String empresa, String lugarSalida, String lugarLlegada, LocalDate fechaInicio, LocalDate fechaFinal) {
        this.id = id;
        this.nombreVuelo = nombreVuelo;
        this.empresa = empresa;
        this.lugarSalida = lugarSalida;
        this.lugarLlegada = lugarLlegada;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public Vuelo() {
    }


    // 2. Los getters necesarios para filtrar por fecha:
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    // 3. Para imprimir la información del vuelo en consola haremos un ToString:
    @Override
    public String toString() {
        return nombreVuelo + " | "
                + empresa + " | "
                + lugarSalida + " -> "
                + lugarLlegada + " | "
                + fechaInicio + " hasta "
                + fechaFinal;
    }
}
