# 🧠 Prueba Técnica - Gestión de Clientes (Java + JPA) 🧠

Este es un proyecto que hice para la prueba técnica del curso 1 del bootcamp.
Es una aplicación de consola en Java que sirve para gestionar clientes: se pueden agregar, ver, editar, eliminar y buscar por ciudad.
Para guardar los datos se usa JPA (Hibernate) y una base de datos MySQL.



# 📌 ¿Qué hace la app? 📌
Cuando se ejecuta el programa, aparece un menú en la consola con las siguientes opciones:

- Agregar un cliente nuevo.

- Ver todos los clientes guardados.

- Editar un cliente (por ID).

- Borrar un cliente (por ID).

- Buscar clientes por ciudad.

- Salir del programa.

- El usuario escribe un número y se ejecuta la opción.



# 🛠️ Cómo ejecutar el proyecto 🛠️

1. Clonar el repositorio:
git clone https://github.com/usuario/cliente-app-jpa.git
cd cliente-app-jpa


2. Crear la base de datos en MySQL Desde MySQL o Workbench:
CREATE DATABASE clientes_db;


3. Revisar configuración de conexión:
En el archivo src/main/resources/META-INF/persistence.xml, cambiar el usuario y contraseña si es necesario:

<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/clientes_db?serverTimezone=UTC"/>
<property name="javax.persistence.jdbc.user" value="root"/>
<property name="javax.persistence.jdbc.password" value="aquí_va_tu_contraseña"/>


4. Ejecutar el programa
Desde IntelliJ o desde consola:

mvn compile
mvn exec:java -Dexec.mainClass="com.hackaboss.Main"



# Qué practiqué con este proyecto ✅✅

- Java básico y estructuras de control.

- Validación de datos por consola.

- CRUD con JPA (Hibernate).

- Conexión con base de datos MySQL.

- Uso de IntelliJ y Maven.



# Supuestos!

+ Se asume que los datos ingresados por el que utiliza la aplicación son correctos (solo se valida que no estén vacíos).

+ El ID del cliente se genera automáticamente.

+ La app corre en la consola -> no hay interfaz gráfica.

+ El user ya tendrá MySQL instalado y corriendo localmente.



# CÓMO PROBARLO

1) Ejecutar la clase Main.java

2) Probar cada opción del menú

3) Ver los resultados por consola

4) Salir con la opción 0





Gracias por el tiempo invertido en leer esto.
