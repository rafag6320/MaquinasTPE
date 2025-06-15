package TPEspecial;

import java.util.ArrayList;
import java.util.List;

public class Greedy {
	private List<Maquina> solucion;
 	private int contador;

	public Greedy() {
	   this.solucion = new ArrayList<>();
	   this.contador = 0;  
    }

  	public List<Maquina> obtenerSecuencia(List<Maquina> maquinas,int cantidadPiezas) {
	  solucion.clear();
	  maquinas.sort(SortearPorPiezasCapacidad);
	  greedyTpEspecial(maquinas,cantidadPiezas,contador);
	  return solucion;
  	}
  
  	public void greedyTpEspecial(List<Maquina> maquinas, int cantidadPiezas,int piezasActual) {
		if(cantidadPiezas!=piezasActual) {
		  	for(Maquina maquina : maquinas) {
			 	if(piezasActual + maquina.getPieza() <= cantidadPiezas){
					piezasActual += maquina.getPieza();
				 	solucion.add(maquina);
				}
			}
		}
	}
} 


