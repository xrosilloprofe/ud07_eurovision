package es.ieslavereda;

import java.util.*;
import java.util.stream.Collectors;

public class Eurovision {

    List<Pais> eurovision;

    public Eurovision(List<Pais> paises){
        eurovision = new ArrayList<>(paises);
    }

    public List<Pais> getEurovision(){ return eurovision;}

    public void realizarVotaciones(){
        for(Pais pais:eurovision){
            List<Pais> aux = new ArrayList<>(eurovision);
            Map<Pais, Integer> puntuacionesPais=new TreeMap<>();
            //Los paises no se pueden votar a si mismos.
            aux.remove(pais);
            Collections.shuffle(aux);
            int i=0;
            for(Puntuacion puntuacion:Puntuacion.values()){
                puntuacionesPais.put(aux.get(i++),puntuacion.getValue());
            }
            pais.setVotaciones(puntuacionesPais);
        }
        ponerPuntosPais();
    }

    private void ponerPuntosPais(){
        for (Pais pais:eurovision){
            int puntos=0;
            for(Pais restoPaises:eurovision){
                if(restoPaises.getVotaciones().keySet().contains(pais))
                    puntos += restoPaises.getVotaciones().get(pais);
            }
            pais.setPuntos(puntos);
        }
    }

    public Pais ganador(){
        Optional<Pais> aux = eurovision.stream().sorted(Comparator.comparing(Pais::getPuntos).reversed()).limit(1).findFirst();
        return aux.get();
    }

    @Override
    public String toString() {
        String cadena = "Eurovision=\n";
        for (Pais pais:eurovision){
            cadena += pais+"\n";
            List<Map.Entry<Pais,Integer>> mapa = pais.getVotaciones().entrySet().stream().
                    sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());

            for(Map.Entry<Pais,Integer> votado:mapa){
                cadena += "\t"+votado.getKey().getNombre() + " puntos: " + votado.getValue() + "\n";
            }
        }
        return cadena;
    }
}
