package es.ieslavereda;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return nombre.hashCode()+representante.hashCode()+cancion.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return nombre.equals(pais.getNombre());
    }

    @Override
    public String toString() {
        return "Pais: " +
                "nombre=" + nombre + ", representante=" + representante + ", cancion=" + cancion;
    }

}
