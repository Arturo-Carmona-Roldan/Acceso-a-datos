import java.io.File;

public class OperacionesDirectorios {

    public static void mostrarDirectorio(File directorio) {

        File[] archivos = directorio.listFiles();

        if (archivos == null) {
            System.out.println("No se puede acceder al directorio.");
            return;
        }

        for (int i = 0; i < archivos.length; i++) {
            System.out.println(archivos[i].getName());
        }
    }


    public static void mostrarDirectorioRecursivo(File directorio, String sangria) {

        File[] archivos = directorio.listFiles();

        if (archivos == null) {
            return;
        }

        for (int i = 0; i < archivos.length; i++) {

            File archivo = archivos[i];

            System.out.println(sangria + archivo.getName());

            if (archivo.isDirectory()) {
                mostrarDirectorioRecursivo(archivo, sangria + "    ");
            }
        }
    }
}