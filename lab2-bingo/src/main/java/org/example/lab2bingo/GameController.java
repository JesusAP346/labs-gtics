package org.example.lab2bingo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class GameController {

    public int[][][] tarjetas;
    public int[][][] validaciones;
    public int banderaGanador=0;

    @GetMapping("/bingo")
    public String mostrarFormulario(){
        return "formulario";
    }
    @PostMapping("/iniciarJuego")
    public String gameStart(GameParameters game,Model model){
        GameConfiguration config =  new GameConfiguration();
        tarjetas = new int[game.getCantidad()][game.getTamanho()][game.getTamanho()];
        validaciones = new int[game.getCantidad()][game.getTamanho()][game.getTamanho()];
        config.llenarTarjetasDeNumerosRandom(tarjetas);


        config.imprimirArreglo(tarjetas);

        model.addAttribute("tarjetas",tarjetas);
        model.addAttribute("validaciones",validaciones);
        model.addAttribute("banderaGanador",banderaGanador);


        return "game";
    }
    @PostMapping("/numeroBingo")
    public String numeroBingo(Model model,@RequestParam("numero") Integer numero){
        GameConfiguration config =  new GameConfiguration();
        config.validarNumeroBingo(numero,tarjetas,validaciones);


        config.imprimirArreglo(validaciones);



        banderaGanador = config.HayGanador(validaciones);

        model.addAttribute("tarjetas",tarjetas);
        model.addAttribute("validaciones",validaciones);
        model.addAttribute("banderaGanador",banderaGanador);

        return "game";
    }
}
