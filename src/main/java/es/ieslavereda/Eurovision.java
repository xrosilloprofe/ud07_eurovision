package es.ieslavereda;

import java.util.*;
import java.util.stream.Collectors;

public class Eurovision {

    List<Pais> eurovision;

    public Eurovision(List<Pais> paises) {
        eurovision = new ArrayList<>(paises);
    }

    public List<Pais> getEurovision() {
        return eurovision;
    }

    public void realizarVotaciones() {
        for (Pais pais : eurovision) {
            List<Pais> aux = new ArrayList<>(eurovision);
            Map<Pais, Puntuacion> puntuacionesPais = new TreeMap<>();
            //Los paises no se pueden votar a si mismos.
            aux.remove(pais);
            Collections.shuffle(aux);
            int i = 0;
            for (Puntuacion puntuacion : Puntuacion.values()) {
                puntuacionesPais.put(aux.get(i++), puntuacion);
            }
            pais.setVotaciones(puntuacionesPais);
        }
        ponerPuntosPais();
    }

    private void ponerPuntosPais() {
        for (Pais pais : eurovision) {
            int puntos = 0;
            for (Pais restoPaises : eurovision) {
                if (restoPaises.getVotaciones().keySet().contains(pais))
                    puntos += restoPaises.getVotaciones().get(pais).getValue();
            }
            pais.setPuntos(puntos);
        }
    }

    public Pais ganador() {
        Optional<Pais> aux = porPuntos().stream().limit(1).findFirst();
        return aux.get();
    }

    public Map<String, Integer> puntosPorPais(Pais pais) {
        Map<String, Integer> votados = new HashMap<>();
        for (Pais restoPaises : eurovision) {
            if (restoPaises.getVotaciones().keySet().contains(pais))
                votados.put(restoPaises.getNombre(),restoPaises.getVotaciones().get(pais).getValue());
        }
        return votados;
    }

    public List<String> porNombreCancion() {
        return eurovision.stream().
                sorted(Comparator.comparing(Pais::getCancion, String.CASE_INSENSITIVE_ORDER)).
                map(Pais::getCancion).collect(Collectors.toList());
    }

    public List<Pais> porPuntos() {
        return eurovision.stream().sorted(Comparator.comparing(Pais::getPuntos).reversed()).collect(Collectors.toList());
    }

    public List<Pais> podium() {
        return porPuntos().stream().limit(3).collect(Collectors.toList());
    }

    public List<String> porNombreRepresentante() {
        return eurovision.stream().
                sorted(Comparator.comparing(Pais::getRepresentante, String.CASE_INSENSITIVE_ORDER)).
                map(Pais::getRepresentante).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        String cadena = "Eurovision=\n";
        for (Pais pais : eurovision) {
            cadena += pais + "\n";
            List<Map.Entry<Pais, Puntuacion>> mapa = pais.getVotaciones().entrySet().stream().
                    sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
            cadena += "Puntos emitidos\n";
            for (Map.Entry<Pais, Puntuacion> votado : mapa) {
                cadena += "\t" + votado.getKey().getNombre() + " puntos: " + votado.getValue() + "\n";
            }
        }
        return cadena;
    }
}
