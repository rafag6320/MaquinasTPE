package MaquinasTpe;

import java.util.ArrayList;
import java.util.List;

public class Greedy {
    public static Solucion greedy(List<Maquina> maquinas, int piezasAProducir){
        //Se ordenan las maquinas de mayor a menor
        maquinas.sort((a,b)->b.getPiezas()-a.getPiezas());

        List<Maquina>resultado = new ArrayList<>();
        int sumaActual=0;
        int candidatosTotales=0;

        for(Maquina m : maquinas){
            while(sumaActual + m.getPiezas() <= piezasAProducir){
                resultado.add(m);
                sumaActual += m.getPiezas();
                candidatosTotales++; 
                if(sumaActual == piezasAProducir){
                    return new Solucion(resultado, candidatosTotales);
                }
            }
        }
        return new Solucion(resultado, candidatosTotales);
    }
}

