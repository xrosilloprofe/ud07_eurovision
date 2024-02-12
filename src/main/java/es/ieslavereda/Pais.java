package es.ieslavereda;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Pais {

    private String nombre;
    private String representante;
    private String cancion;
    private Map<Puntuacion, Pais> votaciones;
    private int puntos;

    public Pais(String nombre, String representante, String cancion) {
        this.nombre = nombre;
        this.representante = representante;
        this.cancion = cancion;
        votaciones = new TreeMap<>();
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

    public Map<Puntuacion, Pais> getVotaciones() {return votaciones;}

    public void setVotaciones(Map<Puntuacion, Pais> votaciones){
        this.votaciones = votaciones;
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
