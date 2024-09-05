package org.example.lab2bingo;

public class GameConfiguration {

    public void llenarTarjetasDeNumerosRandom(int[][][] tarjetas) {
        for(int k=0;k<tarjetas.length;k++) {
            for(int i=0;i<tarjetas[k].length;i++) {
                for(int j=0;j<tarjetas[0][0].length;j++) {
                    tarjetas[k][i][j] =(int)(Math.random()*99+1);
                }
            }
        }
    }


    public void validarNumeroBingo(int numero, int[][][] tarjetas, int[][][] validaciones) {
        for(int k=0;k<tarjetas.length;k++) {
            for(int i=0;i<tarjetas[k].length;i++) {
                for(int j=0;j<tarjetas[0][0].length;j++) {
                    if(tarjetas[k][i][j] == numero) {
                        validaciones[k][i][j] = 1;
                    }
                }
            }
        }
    }

    public void imprimirArreglo(int[][][] arreglo) {
        for(int k=0;k<arreglo.length;k++) {
            for(int i=0;i<arreglo[k].length;i++) {
                for(int j=0;j<arreglo[0][0].length;j++) {
                    System.out.print(arreglo[k][i][j]);
                    System.out.print(" ");
                }
                System.out.println("");
            }
            System.out.println("------------");
        }
    }

    public int HayGanador(int[][][] validaciones) {
        int ganador = 0;
        for(int k=0;k<validaciones.length;k++) {
            boolean hay0 = false;
            for(int i=0;i<validaciones[k].length;i++) {
                for(int j=0;j<validaciones[0][0].length;j++) {
                    if(validaciones[k][i][j] == 0){
                        hay0=true;
                    }
                }
            }
            if(!hay0) {
                ganador =  k;
            }
        }
        return ganador;
    }
}
