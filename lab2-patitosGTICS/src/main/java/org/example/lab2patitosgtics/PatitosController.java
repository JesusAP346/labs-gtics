package org.example.lab2patitosgtics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.Arrays;

@Controller
public class PatitosController {

    public int [][][] laguna;


    @GetMapping("/patito_hule")
    public String formulario(){
        return "formulario";
    }

    @PostMapping("/mostrarFotografias")
    public String formularioPost(PatitosPropiedades propiedades,Model model){
        GameConfiguration config = new GameConfiguration();
        laguna = new int[propiedades.getFotos()][propiedades.getFilas()][propiedades.getColumnas()];
        int [][][] copia = new int[propiedades.getFotos()][propiedades.getFilas()][propiedades.getColumnas()];
        config.ingresarPatosAlaguna(propiedades.getPosiciones(),laguna);
        int numeroFinDePatitos = config.iterarHastaTerminar(laguna,copia,propiedades.getFotos());

        System.out.println("Finaliza en iteracion: " + numeroFinDePatitos);




        model.addAttribute("laguna",laguna);
        return "game";
    }

}
