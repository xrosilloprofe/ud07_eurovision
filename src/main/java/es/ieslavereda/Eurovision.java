package es.ieslavereda;

import javax.print.attribute.standard.PrinterIsAcceptingJobs;
import java.util.*;

public class Eurovision {

    List<Pais> eurovision;

    public Eurovision(List<Pais> paises){
        eurovision = new ArrayList<>(paises);
    }

    public List<Pais> getEurovision(){ return eurovision;}

    public void realizarVotaciones(){
        for(Pais pais:eurovision){
            List<Pais> aux = new ArrayList<>(eurovision);
            Map<Puntuacion, Pais> puntuacionesPais=new TreeMap<>();
            //Los paises no se pueden votar a si mismos.
            aux.remove(pais);
            Collections.shuffle(aux);
            int i=0;
            for(Puntuacion puntuacion:Puntuacion.values()){
                puntuacionesPais.put(puntuacion,aux.get(i++));
            }
            pais.setVotaciones(puntuacionesPais);
        }
    }

    public Pais buscarPaisGanador(){
        Pais ganador;
        int max=0;
        for (Pais pais:eurovision){
            int puntos =0;
            for(Pais pais1:eurovision){
                if(pais1.getVotaciones().values().contains(pais))
                    puntos += pais1.getVotaciones().
            }
        }

    }

    @Override
    public String toString() {
        String cadena = "Eurovision=\n";
        for (Pais pais:eurovision){
            cadena += pais+"\n";
            for (Puntuacion puntos:pais.getVotaciones().keySet()){
                cadena += "\t"+pais.getVotaciones().get(puntos).getNombre()+ " puntos: " + puntos.getValue() + "\n";
            }
        }
        return cadena;
    }
}
