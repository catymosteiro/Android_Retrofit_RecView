package edu.upc.dsa.tracks.IO;

public class Repositorio {

    String nombre;
    String lenguaje;

    public String getNombre() {
        return nombre;
    }

    public void setLogin(String nombre) {
        this.nombre = nombre;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setAvatar_url(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    @Override
    public String toString() {
        return "Repositorio{" +
                "nombre='" + nombre + '\'' +
                ", lenguaje='" + lenguaje + '\'' +
                '}';
    }
}
