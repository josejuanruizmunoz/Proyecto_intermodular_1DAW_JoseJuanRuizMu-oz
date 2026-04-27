USE thebugfixerbarbers;

-- 1. CLIENTES (Metemos 5 clientes variados)
INSERT INTO clientes (nombre, telefono, email) VALUES
('Juan Pérez', '600111222', 'juan@email.com'),
('Carlos Gómez', '611333444', 'carlos@email.com'),
('Luis Martínez', '622555666', NULL),
('Ana López', '633777888', 'ana.lopez@email.com'),
('Miguel Sánchez', '644999000', 'miguel.s@email.com');

-- 2. SERVICIOS (Ampliamos el catálogo)
INSERT INTO servicios (nombre_servicio, precio, duracion) VALUES
('Corte Clásico', 15.00, 30),
('Arreglo de Barba', 10.00, 20),
('Corte + Lavado', 18.00, 40),
('Tinte', 25.00, 45),
('Corte Premium y Masaje', 30.00, 60),
('Afeitado a Navaja', 12.00, 25);

-- 3. CITAS (Generamos historial: pasadas, futuras y canceladas)
INSERT INTO citas (fecha_hora, id_cliente, estado, notas) VALUES
('2026-04-10 10:00:00', 1, 'Completada', 'Primera visita.'),
('2026-04-10 11:30:00', 2, 'Completada', NULL),
('2026-04-11 17:00:00', 3, 'No_Presentado', 'Se le llamó y no lo cogió.'),
('2026-04-12 10:00:00', 1, 'Completada', 'Viene a por un repaso para una boda.'),
('2026-04-20 18:00:00', 4, 'Pendiente', 'Llega 10 mins tarde.'),
('2026-04-21 12:00:00', 5, 'Cancelada', 'Avisó por WhatsApp.');

-- 4. CITA_SERVICIO (Unimos todo. Tienen varios servicios)
-- Cita 1 (Juan): Corte y Barba
INSERT INTO cita_servicio (id_cita, id_servicio, cantidad, precio_aplicado, duracion_aplicada) VALUES
(1, 1, 1, 15.00, 30),
(1, 2, 1, 10.00, 20);

-- Cita 2 (Carlos): Corte + Lavado
INSERT INTO cita_servicio (id_cita, id_servicio, cantidad, precio_aplicado, duracion_aplicada) VALUES
(2, 3, 1, 18.00, 40);

-- Cita 3 (Luis - No presentado): Tenía reservado Tinte y Corte
INSERT INTO cita_servicio (id_cita, id_servicio, cantidad, precio_aplicado, duracion_aplicada) VALUES
(3, 4, 1, 25.00, 45),
(3, 1, 1, 15.00, 30);

-- Cita 4 (Juan repite): Tinte y Afeitado
INSERT INTO cita_servicio (id_cita, id_servicio, cantidad, precio_aplicado, duracion_aplicada) VALUES
(4, 4, 1, 25.00, 45),
(4, 6, 1, 12.00, 25);

-- Cita 5 (Ana - Pendiente): Corte Premium
INSERT INTO cita_servicio (id_cita, id_servicio, cantidad, precio_aplicado, duracion_aplicada) VALUES
(5, 5, 1, 30.00, 60);

-- Cita 6 (Miguel - Cancelada): Corte Clásico
INSERT INTO cita_servicio (id_cita, id_servicio, cantidad, precio_aplicado, duracion_aplicada) VALUES
(6, 1, 1, 15.00, 30);

-- Insertamos el primer administrador 
INSERT INTO Usuarios (username, password, rol) 
VALUES ('admin_josejuan', '1234', 'ADMIN');

-- Insertamos un cliente de prueba
INSERT INTO Usuarios (username, password, rol) 
VALUES ('cliente_prueba', '1234', 'CLIENTE');