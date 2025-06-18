import java.util.List;

public class LectorArchivo {
    public static int piezasTotales;

    public static List<Maquina> leerArchivo(String path){

        List<Maquina> maquinas = new ArrayList<>();
        List<String> lineas = Files.readAllLines(Paths.get(path));

        piezasTotales = Integer.parseInt(lineas.get(0));

        for (int i = 1; i < lineas.size(); i++) {
            String[] partes = lineas.get(i).split(",");
            Maquina nueva = new Maquina(partes[0], Integer.parseInt(partes[1]));
            maquinas.add(nueva);
        }

        return maquinas;
    }
}
