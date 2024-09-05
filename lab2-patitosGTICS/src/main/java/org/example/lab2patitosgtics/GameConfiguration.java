package org.example.lab2patitosgtics;

import java.util.Arrays;

public class GameConfiguration {

    public void ingresarPatosAlaguna(String posicionesStr, int[][][] laguna) {
        String[] palabras = posicionesStr.split(" ");
        int [][] posiciones = new int[palabras.length][2];
        for(int i = 0; i < palabras.length; i++){
            String palabra = palabras[i].replace(")","").replace("(","");
            String [] coordenada = palabra.split(",");
            posiciones[i][0] = Integer.parseInt(coordenada[0])-1;
            posiciones[i][1] = Integer.parseInt(coordenada[1])-1;
        }

        for(int i = 0; i < posiciones.length; i++){
            laguna[0][posiciones[i][0]][posiciones[i][1]] = 1;
        }

    }

    public void imprimirLaguna(int[][][] laguna){
        for(int k=0; k < laguna.length; k++){
            for(int i = 0; i < laguna[0].length; i++){
                for(int j =0;j<laguna[0][0].length;j++){
                    System.out.print(laguna[k][i][j]);
                    System.out.print(" ");
                }
                System.out.println(" ");
            }
            System.out.println("--------------------------");
        }
    }

    public void iterarHastaTerminar(int[][][] laguna,int[][][] copiaLaguna) {
        // Copiamos toda la matriz tridimensional
        copiarLaguna(laguna,copiaLaguna);
        // Modificamos la laguna con la lógica de contar patitos alrededor
        for (int k = 0; k < laguna.length - 1; k++) {  // Aseguramos que no excedemos los límites en k+1
            copiarLaguna(laguna,copiaLaguna);
            for (int i = 0; i < laguna[0].length; i++) {
                for (int j = 0; j < laguna[0][0].length; j++) {
                    int cantidad = contarPatitosAlRededor(copiaLaguna, i, j, k);
                    if (cantidad == 3) {
                        laguna[k + 1][i][j] = 1;  // Actualizamos a la siguiente capa
                    } else if (cantidad < 2 || cantidad > 3) {
                        laguna[k + 1][i][j] = 0;  // Menos de 2 o más de 3 patitos
                    } else {
                        laguna[k + 1][i][j] = copiaLaguna[k][i][j];  // Mantiene el estado actual
                    }
                }
            }
        }



    }

    private void copiarLaguna(int[][][] laguna, int[][][] copiaLaguna) {
        for (int k = 0; k < laguna.length; k++) {
            for (int i = 0; i < laguna[0].length; i++) {
                for (int j = 0; j < laguna[0][0].length; j++) {
                    copiaLaguna[k][i][j] = laguna[k][i][j];
                }
            }
        }
    }

    public int contarPatitosAlRededor(int[][][] laguna,int x,int y,int k) {
        int cantidad=0;
        int ancho=laguna[0].length;
        int largo=laguna[0][0].length;



        // Verificaciones para evitar índices fuera de los límites
        if (x > 0 && y > 0 && laguna[k][x - 1][y - 1]==1) {
            cantidad++;
        }
        if (x > 0 && laguna[k][x - 1][y]==1) {
            cantidad++;
        }
        if (x > 0 && y < largo - 1 && laguna[k][x - 1][y + 1]==1) {
            cantidad++;
        }
        if (y > 0 && laguna[k][x][y - 1]==1) {
            cantidad++;
        }
        if (y < largo - 1 && laguna[k][x][y + 1]==1) {
            cantidad++;
        }
        if (x < ancho - 1 && y > 0 && laguna[k][x + 1][y - 1]==1) {
            cantidad++;
        }
        if (x < ancho - 1 && laguna[k][x + 1][y]==1) {
            cantidad++;
        }
        if (x < ancho - 1 && y < largo - 1 && laguna[k][x + 1][y + 1]==1) {
            cantidad++;
        }
        return cantidad;
    }
}
