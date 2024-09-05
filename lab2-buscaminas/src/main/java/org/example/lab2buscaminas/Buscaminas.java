package org.example.lab2buscaminas;

public class Buscaminas {
    private int filas;
    private int columnas;
    private int intentos;
    private int bombas;
    private String posiciones;

    public int getBombas() {
        return bombas;
    }

    public void setBombas(int bombas) {
        this.bombas = bombas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public String getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(String posiciones) {
        this.posiciones = posiciones;
    }
}
