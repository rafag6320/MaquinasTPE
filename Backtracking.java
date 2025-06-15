package TPEspecial;

import java.util.List;

public class Backtracking {
	private List<Maquina> recorridoActual;
	private List<Maquina> soluciones;
	private int contadorEstados;
	   
	    
	public List<Maquina> obtenerSecuencia(List<Maquina> maquinas, int piezasRequeridas) {
        recorridoActual.clear();
	    Backtracking(maquinas, piezasRequeridas, 0);
	    return soluciones;
	}
    
    private void Backtracking(List<Maquina> maquinas, int piezasRequeridas, int contadorPiezasActuales) {
        contadorEstados++;//cantidad de estados generados;
        if(contadorPiezasActuales==piezasRequeridas) {
            if (soluciones.isEmpty() || soluciones.size() > recorridoActual.size()){
                soluciones.clear();
                soluciones.addAll(recorridoActual); 
            }
        } else {
            if (!soluciones.isEmpty() && recorridoActual.size() >= soluciones.size()) {
                return;
            }
            for (Maquina maq : maquinas){
                contadorPiezasActuales += maq.getPieza();
                if (contadorPiezasActuales <= piezasRequeridas) {
                    recorridoActual.add(maq);
                    Backtracking(maquinas, piezasRequeridas, contadorPiezasActuales);
                    recorridoActual.removeLast();
                }
                contadorPiezasActuales -= maq.getPieza();
            }
        }
    }
}
