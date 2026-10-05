package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Dispositivo dispositivo = new Dispositivo("Samsung", 10000);

        int opcion;

        //bucle para que aparezca el menu al menos una vez
        do {
            System.out.println();
            System.out.println("===== GESTOR DE APPS =====");
            System.out.println("1. Instalar aplicación");
            System.out.println("2. Listar aplicaciones");
            System.out.println("3. Consultar aplicación");
            System.out.println("4. Desinstalar aplicación");
            System.out.println("5. Consultar almacenamiento disponible");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            //dependiendo del numero se ejecuta un caso diferente
            switch (opcion) {

                case 1:
                    System.out.println();
                    System.out.println("¿Qué tipo de aplicación quieres instalar?");
                    System.out.println("1. Juego");
                    System.out.println("2. Utilidad");
                    System.out.print("Elige una opción: ");

                    int tipo = Integer.parseInt(scanner.nextLine());

                    if (tipo != 1 && tipo != 2) {
                        System.out.println("Tipo de aplicación incorrecto.");
                        break;
                    }

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Versión: ");
                    String version = scanner.nextLine();

                    System.out.print("Peso en MB: ");
                    double peso = Double.parseDouble(scanner.nextLine());

                    Aplicacion nuevaApp;

                    if (tipo == 1) {
                        System.out.print("¿Es multijugador? (s/n): ");
                        String respuesta = scanner.nextLine();

                        boolean multijugador = respuesta.equalsIgnoreCase("s");

                        nuevaApp = new Juego(
                                nombre,
                                version,
                                peso,
                                multijugador
                        );

                    } else {
                        System.out.print("Categoría: ");
                        String categoria = scanner.nextLine();

                        nuevaApp = new Utilidad(
                                nombre,
                                version,
                                peso,
                                categoria
                        );
                    }

                    if (dispositivo.instalarApp(nuevaApp)) {
                        System.out.println("Aplicación instalada correctamente.");
                    } else {
                        System.out.println("No hay suficiente almacenamiento.");
                    }

                    break;

                case 2:
                    System.out.println();
                    System.out.println("===== APLICACIONES INSTALADAS =====");
                    dispositivo.mostrarAppsInstaladas();
                    break;

                case 3:
                    System.out.print("Introduce el nombre de la aplicación: ");
                    String nombreBuscar = scanner.nextLine();

                    String informacion =
                            dispositivo.informacionApp(nombreBuscar);

                    if (informacion != null) {
                        System.out.println(informacion);
                    } else {
                        System.out.println("Aplicación no encontrada.");
                    }

                    break;

                case 4:
                    System.out.print("Introduce el nombre de la aplicación a desinstalar: ");
                    String nombreEliminar = scanner.nextLine();

                    if (dispositivo.desinstalarApp(nombreEliminar)) {
                        System.out.println("Aplicación desinstalada correctamente.");
                    } else {
                        System.out.println("Aplicación no encontrada.");
                    }

                    break;

                case 5:
                    System.out.println(
                            "Almacenamiento disponible: "
                                    + dispositivo.obtenerAlmacenamientoDisponible()
                                    + " MB"
                    );
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 6);

        scanner.close();
    }
}