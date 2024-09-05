package org.example.lab2buscaminas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class GameController {

    public int[][] posicionesBombasArray; //arreglo que indica la posicion de cada bomba
    public int[][][] casillas; //arreglo de casillas
    //[0][i][j] casillas :  enteros que indica si hay bombas o no (1: hay bomba  || 0: no hay bomba )
    //[1][i][j] casillas :  enteros que indican el estado de la parcela (0: parcela celeste || 1:parcela rosada || 2:parcela verde)
    //[2][i][j] casillas :  enteros que indican la cantidad de bombas al rededor
    public int intentos;


    @GetMapping("/buscaminas")
    public String configuracion(){
        return "configuracion";
    }

    @PostMapping("/jugar")
    public String configuracionPost(Buscaminas buscaminas,Model model){
        //imprimimos para verificar
        System.out.println(buscaminas.getFilas());
        System.out.println(buscaminas.getColumnas());
        System.out.println(buscaminas.getIntentos());
        System.out.println(buscaminas.getBombas());
        System.out.println(buscaminas.getPosiciones());
        //
        intentos = buscaminas.getIntentos();

        GameConfiguration config = new GameConfiguration();
        posicionesBombasArray = new int[buscaminas.getBombas()][2];
        casillas = new int[3][buscaminas.getFilas()][buscaminas.getColumnas()];
        config.colocarPosicionesBombasEnArreglo(buscaminas.getPosiciones(), posicionesBombasArray);
        config.colocarBombasEnArregloInt(casillas, posicionesBombasArray);
        config.llenarArarregloDe0(casillas,1);//mandamos el 1 para indicar que vamos a llenar de 0 el arreglo de parcelas

        model.addAttribute("casillas",casillas);

        return "game";
    }
    @PostMapping("/minar")
    public String getMinar(@RequestParam("coordenada") String coordStr,Model model){
        GameConfiguration config = new GameConfiguration();

        String[] posicionesStr = coordStr.split(" ");
        boolean hayBomba = config.explotarParcela(casillas,posicionesStr); //retorna true si hay bomba y false si no hay
        String mensaje = "";
        if(hayBomba){
            intentos-=1;
            mensaje = "menos1Intento";
        }

        if(intentos==0){
            mensaje = "perdiste";
        }


        //lenamos los numeros alrededor de las bombas
        config.llenarCantidadDeBombasAlRededor(casillas);
        config.imprimirArreglo(casillas);


        model.addAttribute("casillas",casillas);
        model.addAttribute("intentos",intentos);
        model.addAttribute("mensaje",mensaje);

        return "game";
    }
}
