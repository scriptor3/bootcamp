package Entities;
import jakarta.persistence.*;
import java.time.LocalDate;

//Entity se utiliza para marcar que esta clase será mapeada a una tabla en DB (dataBase).
//Table se utiliza para darle nombre a la tabla.
@Entity
@Table(name = "Clientes")
public class ClienteUsuario {


    //ID es el identificador único para clientes
    //GeneratedValue es el que indica que se generará automáticamente.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String nombre;
    private String apellidos;
    private String sexo;
    private String ciudad;
    private int telefono;
    private String email;
    //variables que representarán datos de los clientes en columnas en la tabla "Clientes".

    private LocalDate fechaDeNacimiento;
    //importamos java.time.LocalDate para que siga un orden en la fecha de nacimiento de cada cliente.

    //HORA DE CREAR CONSTRUCTORES
    //1ro Constructor Vacío pedido por JPA
    public ClienteUsuario() {
    }

    //2do Constructores de cada variable
    public ClienteUsuario(String nombre, String apellidos, String sexo, String ciudad, int telefono, String email, LocalDate fechaDeNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.email = email;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }


    //HORA DE CREAR GETTERS Y SETTERS DE LAS VARIABLES

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }


    //HORA DE CREAR UN TOSTRING PARA IMPRIMIR EN CONSOLA EL CLIENTE

    @Override
    public String toString() {
        return "Cliente: {" +

                "| Nombre = " + nombre + '\'' +
                "| Apellidos = " + apellidos + '\'' +
                "| Sexo = " + sexo + '\'' +
                "| Ciudad = " + ciudad + '\'' +
                "| Teléfono = " + telefono + '\'' +
                "| Email = " + email + '\'' +
                "| Fecha de Nacimiento = " + fechaDeNacimiento +
                '}';
    }

    //Ya estaría terminada la clase ClienteUsuario.
}
