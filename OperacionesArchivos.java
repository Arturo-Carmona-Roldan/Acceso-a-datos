import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OperacionesArchivos {

    public static void listarArchivo(File archivo) {

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {

            String linea;

            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }


    public static void listarArchivoNumerado(File archivo) {

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {

            String linea;
            int numeroLinea = 1;

            while ((linea = lector.readLine()) != null) {

                System.out.println(numeroLinea + "- " + linea);

                numeroLinea++;
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }


    public static void encontrarTexto(File archivo, Scanner teclado) {

        System.out.print("Introduce el texto que quieres buscar: ");
        String texto = teclado.nextLine();

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {

            String linea;
            int numeroLinea = 1;

            while ((linea = lector.readLine()) != null) {

                int posicion = linea.indexOf(texto);

                while (posicion != -1) {

                    System.out.println(
                            linea + " - linea " + numeroLinea +
                            " posicion " + posicion
                    );

                    posicion = linea.indexOf(texto, posicion + 1);
                }

                numeroLinea++;
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }


    public static void anexarFichero(File archivoOriginal, Scanner teclado) {

        System.out.print("Introduce el nombre del archivo que quieres anexar: ");
        String nombreArchivo = teclado.nextLine();

        File archivoAnexar = new File(nombreArchivo);

        if (!archivoAnexar.exists()) {
            System.out.println("El archivo que quieres anexar no existe.");
            return;
        }

        if (!archivoAnexar.isFile()) {
            System.out.println("La ruta indicada no corresponde a un archivo.");
            return;
        }

        try (
                BufferedReader lector = new BufferedReader(new FileReader(archivoAnexar));
                FileWriter escritor = new FileWriter(archivoOriginal, true)
        ) {

            String linea;

            escritor.write(System.lineSeparator());

            while ((linea = lector.readLine()) != null) {
                escritor.write(linea);
                escritor.write(System.lineSeparator());
            }

            System.out.println("Archivo anexado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al anexar el archivo.");
        }
    }
}