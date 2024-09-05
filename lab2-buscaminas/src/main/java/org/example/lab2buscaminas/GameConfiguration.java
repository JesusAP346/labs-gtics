package org.example.lab2buscaminas;

import java.util.Arrays;

public class GameConfiguration {
    public void colocarPosicionesBombasEnArreglo(String posiciones, int[][] posicionesBombasArray) {
        String[] palabras = posiciones.split(" ");
        System.out.println(Arrays.toString(palabras));
        for(int i = 0; i < palabras.length; i++){
            String[] numeros = palabras[i].replace("(","").replace(")","").split(",");
            posicionesBombasArray[i][0] = Integer.parseInt(numeros[0])-1;
            posicionesBombasArray[i][1] = Integer.parseInt(numeros[1])-1;
        }
    }

    public void colocarBombasEnArregloInt(int[][][] bombasInt, int[][] posicionesBombasArray) {
        llenarArarregloDe0(bombasInt,0); //mandamos el 0 para indicar que vamos a llenar de 0 el arreglo de bombas
        for(int i = 0; i<posicionesBombasArray.length; i++){
            bombasInt[0][posicionesBombasArray[i][0]][posicionesBombasArray[i][1]]=1;
        }
    }

    public void llenarArarregloDe0(int[][][] bombasInt,int n) {
        for(int i=0;i<bombasInt.length;i++){
            for(int j=0;j<bombasInt[0].length;j++){
                bombasInt[n][i][j] = 0; //cuando n=1: parcelas, cuando n=0: bombas , n=2: cantidad de bombas al rededor
            }
        }
    }



    public boolean explotarParcela(int[][][] casillas, String[] posicionesStr) {

        boolean hayBomba=false;

        //si hay bomba en la parcela, cambia a estado 1 (celda rosada)
        if(casillas[0][Integer.parseInt(posicionesStr[0])-1][Integer.parseInt(posicionesStr[1])-1] ==1){
            casillas[1][Integer.parseInt(posicionesStr[0])-1][Integer.parseInt(posicionesStr[1])-1] = 1;
            hayBomba=true;
        }else{//si no hay bomba en la parcela, cambia a estado 2 (celda verde)
            casillas[1][Integer.parseInt(posicionesStr[0])-1][Integer.parseInt(posicionesStr[1])-1] = 2;
        }
        return hayBomba;
    }

    public void llenarCantidadDeBombasAlRededor(int[][][] casillas) {

        //llenamos arreglo casillas[2][i][j] con cantidad de bombas al rededor de cada celda
        for(int i=0;i<casillas[2].length;i++){
            for(int j=0;j<casillas[2][i].length;j++){
                if(casillas[0][i][j]==1){
                    casillas[2][i][j] = 10; //indicador que es bomba
                }else{
                    casillas[2][i][j] = contarBombasAlRededor(casillas,i,j);
                }

            }
        }

    }

    private int contarBombasAlRededor(int[][][] casillas, int x,int y) {
        int cantidad = 0;
        int ancho = casillas[0].length;
        int largo = casillas[0][0].length;

        // Verificaciones para evitar índices fuera de los límites
        if (x > 0 && y > 0 && casillas[0][x - 1][y - 1]==1) {
            cantidad++;
        }
        if (x > 0 && casillas[0][x - 1][y]==1) {
            cantidad++;
        }
        if (x > 0 && y < largo - 1 && casillas[0][x - 1][y + 1]==1) {
            cantidad++;
        }
        if (y > 0 && casillas[0][x][y - 1]==1) {
            cantidad++;
        }
        if (y < largo - 1 && casillas[0][x][y + 1]==1) {
            cantidad++;
        }
        if (x < ancho - 1 && y > 0 && casillas[0][x + 1][y - 1]==1) {
            cantidad++;
        }
        if (x < ancho - 1 && casillas[0][x + 1][y]==1) {
            cantidad++;
        }
        if (x < ancho - 1 && y < largo - 1 &&  casillas[0][x + 1][y + 1]==1) {
            cantidad++;
        }
        return cantidad;
    }


    public void imprimirArreglo(int[][][] casillas) {

        //llenamos arreglo casillas[2][i][j] con cantidad de bombas al rededor de cada celda
        for(int k=0;k< casillas.length;k++){
            for(int i=0;i<casillas[k].length;i++){
                for(int j=0;j<casillas[k][i].length;j++){
                    System.out.print(casillas[k][i][j]);
                    System.out.print(" ");
                }
                System.out.println(" ");
            }
            System.out.println("--------------- ");
        }



    }

}
