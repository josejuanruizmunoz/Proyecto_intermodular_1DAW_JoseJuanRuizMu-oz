CREATE DATABASE barberia_daw;

CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) UNIQUE NOT NULL,
    email VARCHAR(100),
    activo BOOLEAN DEFAULT TRUE,
    creado_en TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE servicios (
    id_servicio INT AUTO_INCREMENT PRIMARY KEY,
    nombre_servicio VARCHAR(100) NOT NULL,
    precio DECIMAL(5,2) NOT NULL,
    duracion INT NOT NULL, -- Duración en minutos
    activo BOOLEAN DEFAULT TRUE
);


CREATE TABLE citas (
    id_cita INT AUTO_INCREMENT PRIMARY KEY,
    fecha_hora DATETIME NOT NULL,
    id_cliente INT NOT NULL,
    estado ENUM('Pendiente', 'Completada', 'Cancelada', 'No_Presentado') DEFAULT 'Pendiente',
    notas TEXT,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente) 
        ON DELETE RESTRICT
        ON UPDATE CASCADE   
);


CREATE TABLE cita_servicio (
    id_cita INT NOT NULL,
    id_servicio INT NOT NULL,
    cantidad INT DEFAULT 1,
    precio_aplicado DECIMAL(5,2),
    duracion_aplicada INT,
    PRIMARY KEY (id_cita, id_servicio),
    FOREIGN KEY (id_cita) REFERENCES citas(id_cita)
        ON DELETE RESTRICT 
        ON UPDATE CASCADE,
    FOREIGN KEY (id_servicio) REFERENCES servicios(id_servicio)
        ON DELETE RESTRICT 
        ON UPDATE CASCADE
);