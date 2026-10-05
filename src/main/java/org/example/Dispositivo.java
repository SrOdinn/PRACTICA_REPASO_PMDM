package org.example;

import java.util.ArrayList;

public class Dispositivo {

    private String marca;
    private double almacenamientoTotal;
    private double almacenamientoDisponible;
    private ArrayList<Aplicacion> appsInstaladas;

    //construir el dispositivo
    public Dispositivo(String marca, double almacenamientoTotal) {
        this.marca = marca;
        this.almacenamientoTotal = almacenamientoTotal;
        this.almacenamientoDisponible = almacenamientoTotal;
        this.appsInstaladas = new ArrayList<>();
    }

    //marca
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    //alamacenamiento
    public double getAlmacenamientoTotal() {
        return almacenamientoTotal;
    }

    public void setAlmacenamientoTotal(double almacenamientoTotal) {
        this.almacenamientoTotal = almacenamientoTotal;
    }

    //almacenamiento disponible
    public double getAlmacenamientoDisponible() {
        return almacenamientoDisponible;
    }

    public ArrayList<Aplicacion> getAppsInstaladas() {
        return appsInstaladas;
    }

    //instalar aplicacion recibiendo un objeto de tipo aplicacion
    public boolean instalarApp(Aplicacion app) {
        if (app.getPesoMB() <= almacenamientoDisponible) {
            appsInstaladas.add(app);
            almacenamientoDisponible -= app.getPesoMB();
            return true;
        }

        return false;
    }

    //busca la aplliacion por su nombre
    public boolean desinstalarApp(String nombreApp) {
        for (int i = 0; i < appsInstaladas.size(); i++) {
            Aplicacion app = appsInstaladas.get(i);

            if (app.getNombre().equalsIgnoreCase(nombreApp)) {
                almacenamientoDisponible += app.getPesoMB();
                appsInstaladas.remove(i);
                return true;
            }
        }

        return false;
    }

    //devuleve la informacion de todas las aplicaciones
    public String listadoApps() {
        if (appsInstaladas.isEmpty()) {
            return "No hay aplicaciones instaladas.";
        }

        String listado = "";

        for (Aplicacion app : appsInstaladas) {
            listado += app.devolverInfoString();
            listado += "\n--------------------\n";
        }

        return listado;
    }

    //mostrar mensaje por consola, y terminar el metodo
    public void mostrarAppsInstaladas() {
        if (appsInstaladas.isEmpty()) {
            System.out.println("No hay aplicaciones instaladas.");
            return;
        }

        for (Aplicacion app : appsInstaladas) {
            System.out.println(app.devolverInfoString());
            System.out.println("--------------------");
        }
    }

    //buscar aplicacion en cocnreto por su nombre
    public String informacionApp(String nombreApp) {
        for (Aplicacion app : appsInstaladas) {
            if (app.getNombre().equalsIgnoreCase(nombreApp)) {
                return app.devolverInfoString();
            }
        }

        return null;
    }

    //metodo para consultar el almacenamiento disponible actualmente
    public double obtenerAlmacenamientoDisponible() {
        return almacenamientoDisponible;
    }
}