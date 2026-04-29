# Proyecto Intermodular - The Bug Fixer Barbers

## 1. Qué es el proyecto y qué problema resuelve
Es una aplicación desarrollada en Java para la gestión de una barbería ficticia. El programa sirve para llevar el control del negocio, solucionando el problema de la gestión manual de clientes mediante una base de datos real.

## 2. Tecnologías usadas
- Lenguaje: Java (JDK 25)
- Base de datos: MariaDB (mediante XAMPP)
- Conector JDBC: mariadb-java-cliente
- Entorno de desarrollo: IntelliJ IDEA

## 3. Funcionalidades y entidades que gestiona
La aplicación gestiona principalmente la entidad de Clientes, además de un sistema de Usuarios para controlar el acceso. 
Las funcionalidades principales son:
- Sistema de login con roles (Administrador y Cliente).
- Altas de nuevos clientes.
- Listado de todos los clientes registrados.
- Borrado de clientes del sistema.

## 4. Conexión y uso de la base de datos
El programa no guarda los datos en memoria, sino que usa JDBC para conectarse a la base de datos "barberia". Utiliza sentencias preparadas de SQL para realizar operaciones CRUD reales (insertar, leer y borrar) sobre las tablas de clientes y usuarios.

## 5. Arquitectura del proyecto y mejora estructural (MPO)
Para cumplir con los requisitos del módulo optativo (MPO), el proyecto incluye las siguientes mejoras de diseño orientado a objetos:
- Arquitectura en capas (Patrón DAO): El código está estructurado en paquetes. La lógica de la base de datos está separada en el paquete "dao", los objetos en "model" y la conexión en "utils".
- Mejora funcional (Validación de datos): Se ha implementado una clase "Validador" independiente. Antes de guardar un cliente en la base de datos, el programa valida usando expresiones regulares que el email contenga un formato válido y que el teléfono tenga exactamente 9 números.

## 6. Estructura del repositorio
- /src/model/: Contiene las clases base con sus constructores y encapsulación.
- /src/dao/: Contiene las clases que hacen las consultas a la base de datos.
- /src/utils/: Contiene la conexión a la base de datos y las validaciones.
- /src/Main.java: Menú del programa.
- /sql/ (o donde tengas los scripts): Archivos .sql para la base de datos.
- /diagramas/: Diagramas Entidad-Relación y Relacional.

## 7. Instrucciones de instalación y ejecución
1. Abre XAMPP e inicia los servicios de Apache y MySQL.
2. Entra en phpMyAdmin (localhost/phpmyadmin).
3. Importa los scripts SQL para crear la base de datos, crear las tablas y meter los datos iniciales.
4. Abre este proyecto en IntelliJ IDEA.
5. Añade la librería del driver de MariaDB al proyecto (File > Project Structure > Libraries).
6. Ejecuta el archivo Main.java.

## 8. Usuarios para probar la aplicación
Para facilitar la corrección, no hace falta que busques las contraseñas en el código SQL. Puedes usar estos usuarios que ya están registrados por defecto:

Usuario Administrador (tiene acceso al menú completo):
- Usuario: admin_josejuan
- Contrasena: 1234

Usuario Cliente:
- Usuario: cliente_prueba
- Contrasena: 1234