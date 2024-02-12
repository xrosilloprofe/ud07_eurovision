package es.ieslavereda;

import java.util.Map;
import java.util.TreeMap;

public class Pais implements Comparable<Pais> {

    private String nombre;
    private String representante;
    private String cancion;
    private Map<Pais, Puntuacion> votaciones;
    private Integer puntos;

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

    public Map<Pais, Puntuacion> getVotaciones() {return votaciones;}

    public void setVotaciones(Map<Pais, Puntuacion> votaciones){
        this.votaciones = votaciones;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
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
    public int compareTo(Pais pais){
        return nombre.compareTo(pais.getNombre());
    }

    @Override
    public String toString() {
        return "Pais: " +
                "nombre=" + nombre + ", representante=" + representante + ", cancion=" + cancion +", puntos="+puntos;
    }

}
