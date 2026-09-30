import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class LectorCSVFuncional {

    public static List<Empleado> leerCSV(String archivo) {

        Path ruta = Paths.get(archivo);

        try {

            return Files.lines(ruta)
                    .skip(1)
                    .map(linea -> linea.split(",", -1))
                    .filter(datos -> datos.length >= 10)
                    .map(datos -> new Empleado(
                            datos[0].trim(),
                            Double.parseDouble(datos[1].trim()),
                            datos[2].trim(),
                            Integer.parseInt(datos[3].trim()),
                            datos[4].trim(),
                            datos[5].trim(),
                            datos[6].trim(),
                            datos[7].trim(),
                            Integer.parseInt(datos[8].trim()),
                            Double.parseDouble(datos[9].trim())
                    ))
                    .collect(Collectors.toList());

        } catch (IOException e) {

            System.out.println("Error al leer el archivo: " + e.getMessage());

        } catch (NumberFormatException e) {

            System.out.println("Error en el formato de los datos: " + e.getMessage());
        }

        return List.of();
    }
}