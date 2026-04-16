USE barberia_daw;

-- 1. AGENDA DEL DÍA: Ver todas las citas con el nombre del cliente (JOIN simple)
SELECT c.id_cita, c.fecha_hora, cl.nombre AS cliente, cl.telefono, c.estado
FROM citas c
JOIN clientes cl ON c.id_cliente = cl.id_cliente
ORDER BY c.fecha_hora ASC;

-- 2. EL TICKET DETALLADO: Ver qué se hizo y cuánto costó una cita en concreto (Ejemplo: Cita 1)
SELECT cl.nombre AS cliente, s.nombre_servicio, cs.cantidad, cs.precio_aplicado, (cs.cantidad * cs.precio_aplicado) AS total_linea
FROM citas c
JOIN clientes cl ON c.id_cliente = cl.id_cliente
JOIN cita_servicio cs ON c.id_cita = cs.id_cita
JOIN servicios s ON cs.id_servicio = s.id_servicio
WHERE c.id_cita = 1;

-- 3. FACTURACIÓN TOTAL: Dinero generado solo por las citas completadas
SELECT SUM(cs.cantidad * cs.precio_aplicado) AS dinero_total_generado
FROM citas c
JOIN cita_servicio cs ON c.id_cita = cs.id_cita
WHERE c.estado = 'Completada';

-- 4. RANKING DE SERVICIOS: ¿Cuál es el servicio que más se pide? (GROUP BY)
SELECT s.nombre_servicio, COUNT(cs.id_servicio) AS veces_vendido
FROM cita_servicio cs
JOIN servicios s ON cs.id_servicio = s.id_servicio
GROUP BY s.nombre_servicio
ORDER BY veces_vendido DESC;

-- 5. LA LISTA NEGRA: Clientes que alguna vez los hemos marcado como 'No_Presentado'
SELECT DISTINCT cl.nombre, cl.telefono
FROM clientes cl
JOIN citas c ON cl.id_cliente = c.id_cliente
WHERE c.estado = 'No_Presentado';