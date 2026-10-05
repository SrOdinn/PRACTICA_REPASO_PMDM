package org.example;

//hereda de aplicacion mediante el "extends"
public class Juego extends Aplicacion {

    //atributo que me dice si el juego tiene multi o no
    private boolean multijugador;

    //construir el juego con datos comunes de las aplicaciones
    public Juego(String nombre, String version, double pesoMB, boolean multijugador) {
        super(nombre, version, pesoMB);
        this.multijugador = multijugador;
    }

   //getter
    public boolean isMultijugador() {
        return multijugador;
    }

    //setter
    public void setMultijugador(boolean multijugador) {
        this.multijugador = multijugador;
    }

    //sobrescribir el devolverInfoString
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString()
                + "\nMultijugador: "
                + (multijugador ? "Sí" : "No");
    }
}