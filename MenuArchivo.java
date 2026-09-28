import java.io.File;
import java.util.Scanner;

public class MenuArchivo {

    public static void mostrar(File archivo, Scanner teclado) {

        int opcion = -1;

        do {

            System.out.println();
            System.out.println("===== MENÚ ARCHIVO =====");
            System.out.println("1. Listar archivo");
            System.out.println("2. Listar archivo numerado");
            System.out.println("3. Encontrar texto");
            System.out.println("4. Anexar fichero");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            // Captura de excepción si el usuario no introduce un número
            try {
                opcion = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número entero válido.");
                continue; // Vuelve a mostrar el menú sin romper el programa
            }

            switch (opcion) {

                case 1:
                    OperacionesArchivos.listarArchivo(archivo);
                    break;

                case 2:
                    OperacionesArchivos.listarArchivoNumerado(archivo);
                    break;

                case 3:
                    OperacionesArchivos.encontrarTexto(archivo, teclado);
                    break;

                case 4:
                    OperacionesArchivos.anexarFichero(archivo, teclado);
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