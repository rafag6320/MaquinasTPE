package MaquinasTPE;

import java.util.ArrayList;
import java.util.List;

public class Solucion {
    private List<Maquina> secuencia;
    private int piezasProducidas, puestasEnFuncionamiento, estadosGenerados;
    private boolean esValida;

    public Solucion(List<Maquina> secuencia, int estadosGenerados){
        this.secuencia = (secuencia != null) ? secuencia : new ArrayList<>();
        this.estadosGenerados=estadosGenerados;
        this.puestasEnFuncionamiento=secuencia.size();
        this.piezasProducidas=secuencia.stream().mapToInt(Maquina::getPiezas).sum();
        this.esValida = (piezasProducidas > 0);
    }

    public void imprimir() {
        if(esValida){
            System.out.println("Secuencia obtenida: " + secuencia);
            System.out.println("Piezas producidas: " + piezasProducidas);
            System.out.println("Puestas en funcionamiento: " + puestasEnFuncionamiento);
            System.out.println("Estados generados: " + estadosGenerados);
        }else{
            System.out.println("No se pudo obtener una solución exacta");
        }
    }

    public List<Maquina> getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(List<Maquina> secuencia) {
        this.secuencia = secuencia;
    }

    public int getPiezasProducidas() {
        return piezasProducidas;
    }

    public void setPiezasProducidas(int piezasProducidas) {
        this.piezasProducidas = piezasProducidas;
    }

    public int getPuestasEnFuncionamiento() {
        return puestasEnFuncionamiento;
    }

    public void setPuestasEnFuncionamiento(int puestasEnFuncionamiento) {
        this.puestasEnFuncionamiento = puestasEnFuncionamiento;
    }

    public int getEstadosGenerados() {
        return estadosGenerados;
    }

    public void setEstadosGenerados(int estadosGenerados) {
        this.estadosGenerados = estadosGenerados;
    }
    public boolean esValida() {
        return esValida;
    }
    
}
