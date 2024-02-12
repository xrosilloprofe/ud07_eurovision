package es.ieslavereda;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Paises participantes en la final de Eurovisión 2023
        Pais suecia = new Pais("Suecia","Loreen","Tattoo");
        Pais israel = new Pais("Israel","Noa Kirel","Unicorn");
        Pais italia = new Pais("Italia","Mango Mengoni","Due Vite");
        Pais finlandia = new Pais("Finlandia","Käärijä","Cha Cha Cha");
        Pais estonia = new Pais("Estonia","Alika","Bridges");
        Pais australia = new Pais("Australia","Voyager","Promise");
        Pais belgica = new Pais("Bélgica","Gustaph","Because of You");
        Pais austria = new Pais("Austria","Teya & Salena","Who The Hell is Edgar");
        Pais espanya = new Pais("España","Blanca Paloma","Eaea");
        Pais chequia = new Pais("Chequia","Vesna","My Sister's Crown");
        Pais lituania = new Pais("Lituania","Monika Linkyte","Stay");
        Pais armenia = new Pais("Armenia","Brunette","Future Lover");
        Pais chipre = new Pais("Chipre","Andrew Lambrou","Break a Broken Heart");
        Pais suiza = new Pais("Suiza","Remo Forrer","Watergun");
        Pais ucrania = new Pais("Ucrania","Tvorchi","Heart of Steel");
        Pais francia = new Pais("Francia","La Zarra","Évidemment");
        Pais noruega = new Pais("Noruega","Alessandra","Queen of Kings");
        Pais portugal = new Pais("Portugal","Mimicat","Ai Coração");
        Pais eslovenia = new Pais("Eslovenia","Joker Out","Carpe Diem");
        Pais moldavia = new Pais("Moldavia","Pasha Parfeny","Soarele Si Luna");
        Pais albania = new Pais("Albania","Albina & Familja Kelmendi","Duje");
        Pais uk = new Pais("Reino Unido","Mae Muller","I Wrote a Song");
        Pais serbia = new Pais("Serbia","Luke Black","Samo Mi Se Spava");
        Pais polonia = new Pais("Polonia","blanka","Solo");
        Pais croacia = new Pais("Croacia","Let 3","Mama SC!");
        Pais alemania = new Pais("Alemania","Lord of the Lost","Blood & Glitter");

        Eurovision eurovision2023 = new Eurovision(List.of(suecia,israel,italia,finlandia,estonia,australia,belgica,austria,espanya,chequia,
                lituania,armenia,chipre,suiza,ucrania,francia,noruega,portugal,eslovenia,moldavia,albania,uk,serbia,polonia,croacia,alemania));

        eurovision2023.realizarVotaciones();

        // 1. Listado de todos los paises participantes
        List<Pais> paisesParticipantes = eurovision2023.getEurovision();
        System.out.print("Países participantes");
        for(Pais pais: paisesParticipantes)
            System.out.print(" - " + pais.getNombre());
        System.out.println();

        //Listado de todos los paises por orden alfabetico junto con las votaciones realizadas ordenadas de mayor a menor

        System.out.println(eurovision2023);

        //Nombre del pais ganador junto con la puntacion total obtenida y paises que le han votado junto con los puntos asignados por cada uno de ellos
        System.out.println("Ganador");
        System.out.println(eurovision2023.ganador());
        System.out.println(eurovision2023.puntosPorPais(eurovision2023.ganador()));

        //Listado de canciones ordenadas por nombre.
        System.out.println("Ordenadas por nombre de canción");
        System.out.println(eurovision2023.porNombreCancion());

        //Listado de los paises ordenados por puntuaciones recibidas.
        System.out.println("Ordenadas por puntuaciones");
        System.out.println(eurovision2023.porPuntos());

        //Listado de las 3 canciones mas votadas junto con su puntuacion.
        System.out.println("Podium");
        System.out.println(eurovision2023.podium());

        //Listado de cantantes ordenados por nombre
        System.out.println("Cantantes");
        System.out.println(eurovision2023.porNombreRepresentante());

    }

}