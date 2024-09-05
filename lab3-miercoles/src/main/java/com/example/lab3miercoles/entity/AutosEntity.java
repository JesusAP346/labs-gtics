package com.example.lab3miercoles.entity;

public class AutosEntity {
    private int id;
    private String modelo;
    private String color;
    private int kilometraje;
    private int idSede;
    private double costoPorDia;

    public AutosEntity() {

    }

    public AutosEntity(int id, String modelo, String color, int kilometraje, int idSede, double costoPorDia) {
        this.id = id;
        this.modelo = modelo;
        this.color = color;
        this.kilometraje = kilometraje;
        this.idSede = idSede;
        this.costoPorDia = costoPorDia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public double getCostoPorDia() {
        return costoPorDia;
    }

    public void setCostoPorDia(double costoPorDia) {
        this.costoPorDia = costoPorDia;
    }
}
