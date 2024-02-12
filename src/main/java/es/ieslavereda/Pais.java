package es.ieslavereda;

public class Pais {

    private String nombre;
    private String representante;
    private String cancion;

    public Pais(String nombre, String representante, String cancion) {
        this.nombre = nombre;
        this.representante = representante;
        this.cancion = cancion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRepresentante() {
        return representante;
    }

    public String getCancion() {
        return cancion;
    }



}
