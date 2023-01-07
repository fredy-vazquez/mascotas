package com.frvazquez.mascotas.model;

public class Mascota {

    private String nombre;
    private int rating;
    private int foto;

    public Mascota(String nombre, int rating, int foto) {
        this.nombre = nombre;
        this.rating = rating;
        this.foto = foto;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getNombre() {
        return nombre;
    }

    public int getRating() {
        return rating;
    }

    public int getFoto() {
        return foto;
    }
}
