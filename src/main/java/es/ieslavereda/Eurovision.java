package es.ieslavereda;

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
            Map<Pais,Puntuacion> puntuacionesPais=new HashMap<>();
            aux.remove(pais);
            Collections.shuffle(aux);
            int i=0;
            for(Puntuacion puntuacion:Puntuacion.values()){
                puntuacionesPais.put(aux.get(i++),puntuacion);
            }
            pais.setVotaciones(puntuacionesPais);
        }
    }

//            - Los paises no se pueden votar a si mismos.
// - Se desea almacenar las votaciones que realiza cada pais.


}
