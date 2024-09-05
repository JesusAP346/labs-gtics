package com.example.lab3miercoles.entity;

public class SegurosEntity {
    private int id;
    private String empresa;
    private double cobertura;
    private double taifa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public double getCobertura() {
        return cobertura;
    }

    public void setCobertura(double cobertura) {
        this.cobertura = cobertura;
    }

    public double getTaifa() {
        return taifa;
    }

    public void setTaifa(double taifa) {
        this.taifa = taifa;
    }
}
