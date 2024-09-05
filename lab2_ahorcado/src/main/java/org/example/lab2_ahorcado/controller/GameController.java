package org.example.lab2_ahorcado.controller;

import org.example.lab2_ahorcado.GameConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping(value ={"/","/home",""},method = RequestMethod.GET)
public class GameController {

    public char[] palabraArreglo;
    public int[] validarArreglo;
    public int intentos;



    @GetMapping({"/","","/formulario"})
    public String llenarFormulario(){
        return "formulario";
    }

    @PostMapping("/formularioPost")
    public String llenarFormularioPost(@RequestParam("longitud") Integer longitud,
                                       @RequestParam("intentos") Integer intentosObtenidos,
                                       @RequestParam("tema") Integer tema,
                                       Model model
                                       ){
        //verificamos que llega al controlador
        System.out.println(longitud);
        System.out.println(intentosObtenidos);
        System.out.println(tema);
        //

        GameConfig game = new GameConfig();

        intentos = intentosObtenidos;
        validarArreglo = new int[longitud];
        game.llenarDe0(validarArreglo);


        String palabra = game.obtenerPalabra(tema,longitud);
        if(palabra.equals("noHay")){
            model.addAttribute("bandera",0);
            return "formulario";
        }else{
            palabraArreglo = palabra.toCharArray();
        }

        //imprimimos para verificar
        System.out.println(palabra);
        for(int i = 0; i < palabraArreglo.length;i++){
            System.out.println(palabraArreglo[i]);
        }



        model.addAttribute("palabraArreglo",palabraArreglo);
        model.addAttribute("validarArreglo",validarArreglo);
        model.addAttribute("intentos",intentos);



        return "game";
    }

    @PostMapping("/validarLetra")
    public String validarLetra(@RequestParam("letra") Character letra,Model model){
        GameConfig game = new GameConfig();
        System.out.println(letra);

        boolean hayLetra = game.validarLetra(palabraArreglo,validarArreglo,letra);
        if(!hayLetra){
            intentos = intentos - 1;
        }

        model.addAttribute("palabraArreglo",palabraArreglo);
        model.addAttribute("validarArreglo",validarArreglo);
        model.addAttribute("intentos",intentos);
        return "game";
    }

}
