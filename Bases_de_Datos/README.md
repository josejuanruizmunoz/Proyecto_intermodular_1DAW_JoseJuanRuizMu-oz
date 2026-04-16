# Bases de Datos - Proyecto Barberia

En esta carpeta está todo lo relacionado con la base de datos del proyecto. He intentado diseñar un sistema lógico y realista para gestionar el día a día de una barbería.

## Análisis del Negocio y Reglas

Antes de crear las tablas, pensé en como funciona una barbería real para montar la estructura:

1. Clientes: Para pedir una cita hace falta estar registrado. He puesto que el teléfono sea obligatorio y no se pueda repetir (UNIQUE) para evitar duplicados y poder llamarles si pasa algo. El email lo he dejado como opcional.

2. Servicios: Es el cátalogo de la barbería (corte, arreglo de barba, etc.). Cada servicio tiene su precio y el tiempo estimado que se tarda.

3. Citas: Un cliente puede venir muchas veces (Relacion 1:N). A las citas les he puesto un campo estado (Pendiente, Completada, Cancelada o No_Presentado) para llevar un control real y saber, por ejemplo, que clientes nos han dejado tirados.

4. El detalle de la cita (Tabla Puente): Como en una sola cita te puedes hacer varias cosas (por ejemplo: corte y barba), he usado una tabla puente llamada cita_servicio. Un detalle importante que he tenido en cuenta: he metido el precio y la duracion en esta tabla. De esta forma, si el año que viene la barberia sube los precios de los cortes, el historial de citas antiguas se queda con el precio que se cobro en su dia y no se rompe la contabilidad.

## Que hay en esta carpeta 

1. Modelo_ER_Barberia.png: El esquema conceptual Entidad-Relación inicial que dibujé para pensar la estructura.

2. modelo_relacional.puml / .png: El esquema visual con las tablas, claves primarias y foráneas. Lo he hecho usando código PlantUML.

3. creacion.sql: El script que crea la base de datos limpia y monta las 4 tablas con sus relaciones.

4. insercion.sql: Datos de prueba inventados. He metido varios clientes, un catalogo de servicios y citas en distintos estados para poder hacer pruebas.

5. consultas.sql: Un script con varias consultas complejas (usando JOIN, GROUP BY, SUM...) para comprobar que la base de datos funciona y ver como sacaríamos estadisticas o tickets.