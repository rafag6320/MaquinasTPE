package MaquinasTPE;

import java.io.IOException;
import java.util.List;
public class Main {
    public static void main(String[] args) throws IOException{
        List<Maquina> maquinas = LectorArchivo.leerArchivo("MaquinasTPE\\listado.txt");
        int piezasAProducir = LectorArchivo.piezasTotales;


        //Solución con backtracking
        System.out.println("Backtracking");
        Backtrack solucion1 = new Backtrack(maquinas, piezasAProducir);
        Solucion resultado1 = solucion1.backtrack();
        resultado1.imprimir();

        //Solución con Greedy
        System.out.println("\nGreedy");
        Solucion resultado2 = Greedy.greedy(maquinas, piezasAProducir);
        resultado2.imprimir();
    }
}
