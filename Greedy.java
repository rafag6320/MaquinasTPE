package MaquinasTPE;

import java.util.ArrayList;
import java.util.List;

public class Greedy {
	
	/* Candidatos: Máquinas disponibles que puedan producir piezas.
     * 
     * Estrategia: El algoritmo consiste en ordenar todas las máquinas
     * en base a su capacidad de producción, de mayor a menor.
     * Luego, se selecciona la máquina con mayor capacidad y la usa la mayor
     * cantidad de veces posibles hasta que supere el limite de "piezasAProducir"
     * Una vez llegue al limite, se pasa a la siguiente maquina y se actualiza el 
     * conteo de "candidatosTotales".
     * 
     * Si se logra alcanzar exactamente la cantidad de piezas requeridas, el método
     * devuelve un objeto "Solucion" que se encarga de mostrarla más semánticamente.
     * 
     * Si no se encuentra una combinación exacta, se imprime un mensaje que
     * informe sobre esto y se retorna una instancia de "Solucion" vacía.
     * 
     */

    public static Solucion greedy(List<Maquina> maquinas, int piezasAProducir){

        //Se ordenan las maquinas de mayor a menor
        maquinas.sort((a,b)->b.getPiezas()-a.getPiezas());

        List<Maquina>resultado = new ArrayList<>();
        int sumaActual=0;
        int candidatosTotales=0;

        for(Maquina m : maquinas){
            candidatosTotales++; // Por cada maquina visitada se suma un estado
            while(sumaActual + m.getPiezas() <= piezasAProducir){
                resultado.add(m); 
                sumaActual += m.getPiezas();

                // Si se encuentra una solución exacta, se retorna
                if(sumaActual == piezasAProducir){ 
                    return new Solucion(resultado, candidatosTotales);
                }
            }
        }
        
        return new Solucion(null, 0); // No se encontró solución exacta
    }
}

