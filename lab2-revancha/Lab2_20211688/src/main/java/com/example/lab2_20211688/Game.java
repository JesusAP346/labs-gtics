package com.example.lab2_20211688;

public class Game {
    public int numeroRandom(){
        return (int)(Math.random()*99+1);
    }
    public void llenarMatriz(Integer[][] matriz,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matriz[i][j] = numeroRandom();
            }

        }
    }
}
