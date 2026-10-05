package org.example;

public abstract class Aplicacion implements Imprimible {
    //atributos comunes de todas las aplicaciones, private para que solo puedan accederse desde la clase
    private String nombre;
    private String version;
    private double pesoMB;

    //recibe los datos para hacer la aplicacion y guardar en los atributos del objeto
    public Aplicacion(String nombre, String version, double pesoMB) {
        this.nombre = nombre;
        this.version = version;
        this.pesoMB = pesoMB;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public double getPesoMB() {
        return pesoMB;
    }

    public void setPesoMB(double pesoMB) {
        this.pesoMB = pesoMB;
    }

    //sobrescribir metodos ya definidos
    @Override
    public String devolverInfoString() {
        return "Nombre: " + nombre
                + "\nVersión: " + version
                + "\nPeso: " + pesoMB + " MB";
    }
}