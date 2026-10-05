package org.example;

//hereda de Aplicacion
public class Utilidad extends Aplicacion {

    //atributo de espefico de una utilidad
    private String categoria;

    //construir la utilidad
    public Utilidad(String nombre, String version, double pesoMB, String categoria) {
        super(nombre, version, pesoMB);
        this.categoria = categoria;
    }

    //getter
    public String getCategoria() {
        return categoria;
    }

    //setter
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    //sobrescritura
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString()
                + "\nCategoría: " + categoria;
    }
}