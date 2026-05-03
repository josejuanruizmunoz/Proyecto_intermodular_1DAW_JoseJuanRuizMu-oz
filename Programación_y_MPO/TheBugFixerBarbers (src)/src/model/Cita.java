package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cita {
    private int id;
    private int idCliente;
    private int idBarbero;
    private int idServicio;
    private LocalDateTime fechaHora;

    public Cita(int id, int idCliente, int idBarbero, int idServicio, LocalDateTime fechaHora) {
        this.id = id;
        this.idCliente = idCliente;
        this.idBarbero = idBarbero;
        this.idServicio = idServicio;
        this.fechaHora = fechaHora;
    }

    public Cita(int idCliente, int idBarbero, int idServicio, LocalDateTime fechaHora) {
        this.idCliente = idCliente;
        this.idBarbero = idBarbero;
        this.idServicio = idServicio;
        this.fechaHora = fechaHora;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public int getIdBarbero() { return idBarbero; }
    public void setIdBarbero(int idBarbero) { this.idBarbero = idBarbero; }
    public int getIdServicio() { return idServicio; }
    public void setIdServicio(int idServicio) { this.idServicio = idServicio; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Cita #" + id + " | Fecha: " + fechaHora.format(formatter) +
                " | Cliente ID: " + idCliente + " | Barbero ID: " + idBarbero;
    }
}
