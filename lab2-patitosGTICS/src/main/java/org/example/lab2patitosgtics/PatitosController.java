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
        laguna = new int[100][propiedades.getFilas()][propiedades.getColumnas()];
        int [][][] copia = new int[100][propiedades.getFilas()][propiedades.getColumnas()];

        config.ingresarPatosAlaguna(propiedades.getPosiciones(),laguna);
        int numeroFinDePatitos = config.iterarHastaTerminar(laguna,copia,propiedades.getFotos());


        //propiedades.getFotos()
        System.out.println("Finaliza en iteracion: " + numeroFinDePatitos);
        int bandera;
        int cantidadAMostrar=0;
        if(numeroFinDePatitos == propiedades.getFotos()){
            bandera = 1;
            model.addAttribute("fotos",numeroFinDePatitos);
        }else{
            if(numeroFinDePatitos < propiedades.getFotos()){
                bandera = 2;
                cantidadAMostrar = propiedades.getFotos()-numeroFinDePatitos;
                model.addAttribute("fotos",propiedades.getFotos());
            }else{
                bandera = -1;
                cantidadAMostrar = numeroFinDePatitos - propiedades.getFotos();
                model.addAttribute("fotos",propiedades.getFotos());

            }
        }



        model.addAttribute("laguna",laguna);
        model.addAttribute("bandera",bandera);
        model.addAttribute("cantidadAMostrar",cantidadAMostrar);




        return "game";
    }

}
