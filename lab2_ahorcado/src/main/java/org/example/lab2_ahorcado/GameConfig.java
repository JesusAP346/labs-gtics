package org.example.lab2_ahorcado;

import java.util.ArrayList;

public class GameConfig {
    public String obtenerPalabra(int tema, int longitud) {

        String [] animales = {"leon","elefante","tigre","cebra","jirafa","delfin","ballena","gorila",
                "panda","aguila","hipopotamo","koala","lobo","oso","canguro"};
        String [] frutas = {"manzana","platano","kiwi","mango","pera","uva","fresa","naranja",
                "piña","sandía","cereza","melon","papaya","limon","higo"};
        String [] paises = {"Mexico","Canada","Brasil","España","Francia","Italia","Alemania","Japon",
                "Australia","Argentina","Chile","Peru","EstadosUnidos","China","India"};

        String [] arregloPalabras = new String[0];
        ArrayList<String> listaPalabras = new ArrayList<>();
        switch (tema) {
            case 1:
                arregloPalabras = animales;
                break;
            case 2:
                arregloPalabras = frutas;
                break;
            case 3:
                arregloPalabras = paises;
                break;
        }



        for(int i=0;i< arregloPalabras.length ;i++){
            if(arregloPalabras[i].length() == longitud){
                listaPalabras.add(arregloPalabras[i]);
            }
        }

        if(listaPalabras.isEmpty()){
            return "noHay";
        }else{
            String palabra = listaPalabras.get(obtenerNumeroAleatorio(listaPalabras.size()));
            return palabra;
        }


    }

    public int obtenerNumeroAleatorio(int k){
        int numero = (int)(Math.random()*k+0);
        System.out.println("Numero random: " + numero);
        return numero;
    }


    public void llenarDe0(int[] validarArreglo) {
        for(int i = 0; i < validarArreglo.length; i++){
            validarArreglo[i] = 0;
        }
    }

    public boolean validarLetra(char[] palabraArreglo, int[] validarArreglo, char letra) {

        boolean hayLetra = false;
        for(int i = 0; i < palabraArreglo.length; i++){
            if(palabraArreglo[i] == letra){
                validarArreglo[i] = 1;
                hayLetra = true;
            }
        }

        return hayLetra;

    }
}
