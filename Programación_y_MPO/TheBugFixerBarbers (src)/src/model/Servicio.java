package model;

public class Servicio {
    private int id;
    private String nombre;
    private double precio;
    private int duracionMinutos;

    public Servicio(int id, String nombre, double precio, int duracionMinutos) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.duracionMinutos = duracionMinutos;
    }

    public Servicio(String nombre, double precio, int duracionMinutos) {
        this.nombre = nombre;
        this.precio = precio;
        this.duracionMinutos = duracionMinutos;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; }

    @Override
    public String toString() {
        return nombre + " - " + precio + "€ (" + duracionMinutos + " min)";
    }
}
