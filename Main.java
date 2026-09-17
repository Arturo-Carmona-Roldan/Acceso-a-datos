import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        if (args.length == 0) {
            System.out.println("Debes introducir un archivo o directorio.");
            return;
        }

        File ruta = new File(args[0]);

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