
//Creamos esta clase para encapsular las operaciones CRUD usando JPA
package OperacionesCRUD_JPA;

import Entities.ClienteUsuario;
import jakarta.persistence.*;
import java.util.List;

public class ClienteJPA {

    //EntityManagerFactory inicia JPA y se configura con el nombre que pusimos dentro de persistence.xml en persistenceUnit.
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("clientesPU");

    //Para agregar un cliente nuevo a la DB, usaremos este metodo: C -CREATE
    public void add(ClienteUsuario cliente){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin(); //Para iniciar la transacción.
            entityManager.persist(cliente); //Para guardar la entity "cliente".
            entityManager.getTransaction().commit(); // Para confirmar la transacción.

        } catch (Exception exception){
            entityManager.getTransaction().rollback(); //Si ocurre un error, removemos la transacción.
            System.out.println("No se pudo agregar el cliente: " + exception.getMessage());

        }finally{
            entityManager.close(); //Cerramos el EM para que se puedan liberar recursos y vaya más fluído.

        }
    }


    //Para obtener todos los clientes creados de la DB, usaremos el siguiente metodo con una lista: R - READ
    public List<ClienteUsuario> listaCliente(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT c FROM ClienteUsuario c", ClienteUsuario.class).getResultList();
    }


    //Para buscar un cliente por su ID, usaremos el siguiente metodo: R - READ
    public ClienteUsuario busquedaPorId(Long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(ClienteUsuario.class, id); //Si no existe ese id, devuelve un null
    }


    //Para buscar clientes por las ciudades, usaremos el siguiente metodo: R - READ
    public List<ClienteUsuario> busquedaPorCiudad(String ciudad){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT c FROM ClienteUsuario c WHERE c.ciudad = :ciudad", ClienteUsuario.class)
                .setParameter("ciudad", ciudad)
                .getResultList();
    }


    //Para actualizar algún cliente existente, usaremos el siguiente metodo: U - UPDATE
    public void actualizarCliente(ClienteUsuario cliente){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try{
            entityManager.getTransaction().begin();
            entityManager.merge(cliente); //Merge se utiliza para actualizar "cliente" en base a su ID.
            entityManager.getTransaction().commit();

        }catch (Exception e){
            entityManager.getTransaction().rollback();
            System.out.println("No se pudo actualizar el cliente: " + e.getMessage());

        }finally {
            entityManager.close();

        }
    }


    //Para eliminar un cliente por su ID, usaremos el siguiente metodo: D - DELETE
    public void eliminarCliente(Long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try{
            ClienteUsuario cliente = entityManager.find(ClienteUsuario.class, id);

            if (cliente != null){
                entityManager.getTransaction().begin();
                entityManager.remove(cliente); //Remove elimina la entity "cliente" si existe.
                entityManager.getTransaction().commit();

            }else{
                System.out.println("El cliente no ha podido ser localizado.");

            }
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            System.out.println("No se ha podido eliminar el cliente: " + e.getMessage());

        }finally {
            entityManager.close();

        }
    }
}
