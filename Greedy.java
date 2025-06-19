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
  	//para cada maquina se fija si la suma de su cant de piezas es menor a la de producir
            while(sumaActual + m.getPiezas() <= piezasAProducir){
                resultado.add(m); 
                sumaActual += m.getPiezas();
                candidatosTotales++; //Se añade la maquina, se incrementa la cant y aumenta los candidatos usados;
    //Si el resultado es igual devuelve la solucion 
                if(sumaActual == piezasAProducir){
                    return new Solucion(resultado, candidatosTotales);
                }
            }
        }
      //si no devuelve lo que se consiguio devuelve la aproximacion
        return new Solucion(resultado, candidatosTotales);
    }
}

