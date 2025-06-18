package MaquinasTPE;

import java.util.ArrayList;
import java.util.List;

public class Greedy {
    public static Solucion greedy(List<Maquina> maquinas, int piezasAProducir){
        //Se ordenan las maquinas de mayor a menor
        maquinas.sort((a,b)->b.getPiezas()-a.getPiezas());

        List<Maquina>resultado = new ArrayLists<>();
        int sumaActual=0;
        int candidatosTotales=0;

        while(suma<piezasAProducir){
            boolean seAgrego=false;
            for(Maquina m: maquinas){
                candidatosTotales++;
                if(suma+m.getPiezas()<=objetivo){
                    resultado.add(m);
                    suma+=m.getPiezas();
                    seAgrego=true;
                    break;
                }
            }
            //No se puede continuar
            if(!seAgrego) break;
        }
        return new Solucion(resultado, candidatosTotales);
    }
}

