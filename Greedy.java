package MaquinasTPE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Greedy {
    private List<Maquina> solucion;
    private int contador;

    public Greedy() {
        this.solucion = new ArrayList<>();
        this.contador = 0;
    }

    public List<Maquina> obtenerSecuencia(List<Maquina> maquinas, int cantidadPiezas) {
        solucion.clear();

        // Ordenar de mayor a menor cantidad de piezas
        maquinas.sort(Comparator.comparingInt(Maquina::getPieza).reversed());

        greedySeleccion(maquinas, cantidadPiezas, 0);

        return solucion;
    }

    private void greedySeleccion(List<Maquina> maquinas, int cantidadPiezas, int piezasActual) {
        for (Maquina maquina : maquinas) {
            if (piezasActual + maquina.getPieza() <= cantidadPiezas) {
                piezasActual += maquina.getPieza();
                solucion.add(maquina);
                contador++;
            }

            if (piezasActual == cantidadPiezas) {
                break;
            }
        }
    }

    public int getContador() {
        return contador;
    }
}

