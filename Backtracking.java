package MaquinasTPE;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    private List<Maquina> recorridoActual;
    private List<Maquina> soluciones;
    private int contadorEstados;

    public Backtracking() {
        this.recorridoActual = new ArrayList<>();
        this.soluciones = new ArrayList<>();
        this.contadorEstados = 0;
    }

    /**
     * Método principal para obtener la mejor secuencia de máquinas que sumen la cantidad exacta de piezas requeridas.
     */
    public List<Maquina> obtenerSecuencia(List<Maquina> maquinas, int piezasRequeridas) {
        recorridoActual.clear();
        soluciones.clear();
        contadorEstados = 0;

        backtracking(maquinas, piezasRequeridas, 0);
        return soluciones;
    }

    /**
     * Algoritmo de backtracking que busca la combinación de máquinas que sume las piezas requeridas.
     */
    private void backtracking(List<Maquina> maquinas, int piezasRequeridas, int piezasActuales) {
        contadorEstados++; // Aumenta el contador de estados generados

        // Caso base: se alcanzaron las piezas requeridas
        if (piezasActuales == piezasRequeridas) {
            if (soluciones.isEmpty() || recorridoActual.size() < soluciones.size()) {
                soluciones.clear();
                soluciones.addAll(recorridoActual);
            }
            return;
        }

        // Poda: si la solución actual ya es más larga que la mejor encontrada
        if (!soluciones.isEmpty() && recorridoActual.size() >= soluciones.size()) {
            return;
        }

        // Explorar opciones
        for (Maquina maquina : maquinas) {
            int nuevasPiezas = piezasActuales + maquina.getPieza();

            if (nuevasPiezas <= piezasRequeridas) {
                recorridoActual.add(maquina);
                backtracking(maquinas, piezasRequeridas, nuevasPiezas);
                recorridoActual.remove(recorridoActual.size() - 1); // Quitar la última máquina
            }
        }
    }

    public int getContadorEstados() {
        return contadorEstados;
    }
}
