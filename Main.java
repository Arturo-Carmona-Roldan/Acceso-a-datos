import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Error: Debes proporcionar la ruta de un archivo o directorio como parámetro.");
            return;
        }

        Scanner teclado = new Scanner(System.in);
        File ruta = new File(args[0]);

        System.out.println("La ruta proporcionada es: " + ruta);

        if (!ruta.exists()) {
            System.out.println("El archivo o directorio no existe.");
            return;
        }

        if (ruta.isFile()) {
            System.out.println("Es un archivo.");
            MenuArchivo.mostrar(ruta, teclado);

        } else if (ruta.isDirectory()) {
            System.out.println("Es un directorio.");
            MenuDirectorio.mostrar(ruta, teclado);
        }

        teclado.close();
    }
}