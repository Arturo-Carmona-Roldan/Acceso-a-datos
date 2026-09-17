import java.io.File;
import java.util.Scanner;

public class MenuDirectorio {

    public static void mostrar(File directorio, Scanner teclado) {

        int opcion;

        do {

            System.out.println();
            System.out.println("===== MENÚ DIRECTORIO =====");
            System.out.println("1. Mostrar directorio");
            System.out.println("2. Mostrar directorio recursivo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    OperacionesDirectorios.mostrarDirectorio(directorio);
                    break;

                case 2:
                    OperacionesDirectorios.mostrarDirectorioRecursivo(directorio, "");
                    break;

                case 0:
                    System.out.println("Programa terminado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }
}