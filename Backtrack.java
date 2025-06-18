package MaquinasTpe;

import java.util.List;
import java.util.ArrayList;

public class Backtrack {
    private List<Maquina> maquinas;
    private int piezasAProducir;
    private Solucion mejorSolucion;
    private int estadosGenerados;

    public Backtrack(List<Maquina> maquinas, int piezasAProducir) {
        this.maquinas = maquinas;
        this.piezasAProducir = piezasAProducir;
    }

    
    public Solucion backtrack() {
        backtrackRecursivo(new ArrayList<>(), 0);
        return mejorSolucion;
    }

    private void backtrackRecursivo(List<Maquina> actual, int suma) {
        //Se suma cada backtrack que se realiza
        estadosGenerados++;

        //Si se llega al objetivo, se compara con la mejor solucion para agarrar la que contenga menos
        //maquinas
        if (suma == piezasAProducir) {
            if (mejorSolucion == null || actual.size() < mejorSolucion.getSecuencia().size()) {
                mejorSolucion = new Solucion(new ArrayList<>(actual), estadosGenerados);
            }
            return;
        }

        //Si la suma se pasa de pieza a producir, se poda
        if (suma > piezasAProducir) return;

        for (Maquina m : maquinas) {
            actual.add(m);
            backtrackRecursivo(actual, suma + m.getPiezas());
            actual.remove(actual.size() - 1);
        }
    }
}