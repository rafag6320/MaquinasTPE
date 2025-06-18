import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LectorArchivo {
    public static int piezasTotales;

    public static List<Maquina> leerArchivo(String path) throws IOException{

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
