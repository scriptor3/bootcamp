
//Creamos esta clase para crear el Menú en la consola y usar las operaciones CRUD.
package Menu;

import Entities.ClienteUsuario;
import OperacionesCRUD_JPA.ClienteJPA;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ClienteMenu {

    //Usaremos el Scanner para que se lea la entrada del user en la consola.
    private static final Scanner scanner = new Scanner(System.in);

    //Después, creamos la instancia del CRUD para sus operaciones:
    private static final ClienteJPA repositorio = new ClienteJPA();


    //Empezaremos a crear el menú:
    public static void main(String[] args) {
        int opcion;

        //Haremos el bucle principal del menú con un 'do':
        do {
            mostrarMenu();
            System.out.println("¡Le damos la bienvenida! Por favor, seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion){
                case 1 -> agregarCliente();
                case 2 -> listarCliente();
                case 3 -> actualizarCliente();
                case 4 -> eliminarCliente();
                case 5 -> buscarPorCiudad();
                case 0 -> System.out.println("Estás saliendo del programa, gracias por usar nuestro servicio.");
                default -> System.out.println("Opción inválida, inténtelo otra vez.");
            }

        }while (opcion != 0);
    }

    //Crearemos la muestra de las opciones disponibles:
    private static void mostrarMenu(){
        System.out.println("\n***** MENÚ PARA LA GESTIÓN DE CLIENTES *****");
        System.out.println("1) Agregar un nuevo cliente.");
        System.out.println("2) Listar todos los clientes.");
        System.out.println("3) Actualizar la información de un cliente");
        System.out.println("4) Eliminar un cliente.");
        System.out.println("5) Buscar un cliente por la ciudad.");
        System.out.println("0) Salir del menú.");
    }

    //Proceso de agregar cliente:
    private static void agregarCliente(){
        System.out.println("Indique el nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Indique los apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.println("Indique el sexo: ");
        String sexo = scanner.nextLine();
        System.out.println("Indique la ciudad: ");
        String ciudad = scanner.nextLine();
        System.out.println("Indique la fecha de nacimiento (YYYY-MM-DD): ");
        LocalDate fechaDeNacimiento = LocalDate.parse(scanner.nextLine());
        System.out.println("Indique el número de teléfono: ");
        int telefono = Integer.parseInt(scanner.nextLine());
        System.out.println("Indique el correo electrónico: ");
        String email = scanner.nextLine();

        ClienteUsuario cliente = new ClienteUsuario(nombre, apellidos, sexo, ciudad, telefono, email, fechaDeNacimiento);
        repositorio.add(cliente);
        System.out.println("El cliente se ha agregado exitosamente.");
    }

    //Proceso de listar clientes:
    private static void listarCliente(){
        List<ClienteUsuario> clientes = repositorio.listaCliente();
        System.out.println("\n*** LISTA DE CLIENTES ***");
        clientes.forEach(System.out::println);
    }

    //Proceso de actualizar clientes:
    private static void actualizarCliente(){
        System.out.println("Por favor, ingrese el ID del cliente a actualizar: ");
        Long id = Long.parseLong(scanner.nextLine());
        ClienteUsuario cliente = repositorio.busquedaPorId(id);

        if (cliente == null){
            System.out.println("El cliente no ha podido ser localizado.");
            return;
        }
        System.out.print("Su nuevo nombre (actual: " + cliente.getNombre() + "): ");
        cliente.setNombre(scanner.nextLine());
        System.out.print("Su nuevos apellidos (actual: " + cliente.getApellidos() + "): ");
        cliente.setApellidos(scanner.nextLine());
        System.out.print("Su nuevo sexo (actual: " + cliente.getSexo() + "): ");
        cliente.setSexo(scanner.nextLine());
        System.out.print("Su nueva ciudad (actual: " + cliente.getCiudad() + "): ");
        cliente.setCiudad(scanner.nextLine());
        System.out.print("Su nueva fecha de nacimiento (YYYY-MM-DD): ");
        cliente.setFechaDeNacimiento(LocalDate.parse(scanner.nextLine()));
        System.out.print("Su nuevo número de teléfono (actual: " + cliente.getTelefono() + "): ");
        cliente.setTelefono(Integer.parseInt(scanner.nextLine()));
        System.out.print("Su nuevo correo electrónico (actual: " + cliente.getEmail() + "): ");
        cliente.setEmail(scanner.nextLine());

        repositorio.actualizarCliente(cliente);
        System.out.println("El cliente ha sido actualizado correctamente.");
    }

    //Proceso de eliminar clientes:
    private static void eliminarCliente(){
        System.out.println("Por favor, ingrese la ID del cliente que desea eliminar: ");
        Long id = Long.parseLong(scanner.nextLine());
        repositorio.eliminarCliente(id);
        System.out.println("El cliente ha sido eliminado si existía.");
    }

    //Proceso de buscar clientes por ciudad:
    private static void buscarPorCiudad(){
        System.out.println("Por favor, ingrese la ciudad para buscar: ");
        String ciudad = scanner.nextLine();
        List<ClienteUsuario> clientes = repositorio.busquedaPorCiudad(ciudad);

        if (clientes.isEmpty()){
            System.out.println("No se encuentran clientes en la ciudad indicada.");

        }else{
            clientes.forEach(System.out::println);
        }
    }
}
