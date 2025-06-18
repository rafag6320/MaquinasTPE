import java.util.List;

public class Solucion {
    private List<Maquina> secuencia;
    private int piezasProducidas, puestasEnFuncionamiento, estadosGenerados;

    public Solucion(List<Maquina> secuencia, int estadosGenerados){
        this.secuencia=secuencia;
        this.estadosGenerados=estadosGenerados;
        this.puestasEnFuncionamiento=secuencia.size();
        this.piezasProducidas=secuencia.stream().mapToInt(Maquina::getPiezas).sum();
    }

    public void imprimir() {
        System.out.println("Secuencia obtenida: " + secuencia);
        System.out.println("Piezas producidas: " + piezasProducidas);
        System.out.println("Puestas en funcionamiento: " + puestasEnFuncionamiento);
        System.out.println("Estados generados: " + estadosGenerados);
    }   
}
