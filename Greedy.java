package MaquinasTpe;

import java.util.ArrayList;
import java.util.List;

public class Greedy {
	
	/*Candidatos:Maquinas capaces de producir piezas.
	 * Estrategia: la estrategia por la cual realiza el algoritmo, es de
	 * ordenar todas las maquinas posibles por la cantidad de piezas posibles
	 * que puede realizar cada maquina,al elegir la  maquina(Es decir
	 * la mas grande en capacidad de produccion) que le permite acercarse
	 * al total de piezas a producir, la va a reutilizar las cantidades de veces
	 * que pueda hasta que no se lo permita, entonces ahi pasara a la siguiente maquina
	 * mas capaz,al finalizar retornara, tambien al seleccionar una maquina el algoritmo sumara 
	 * los candidatos que se han usado.
	 * Cuando se haya llegado retornara Solucion que guarda la lista total de maquinas utilizadas y 
	 * la cantidad de candidatos.
	 * Al no encontrar solucion nuestro algoritmo envia la aproximacion mas cercana que pudo encontrar.
	 */
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

