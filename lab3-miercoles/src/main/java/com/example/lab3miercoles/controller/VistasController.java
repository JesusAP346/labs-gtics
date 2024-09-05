package com.example.lab3miercoles.controller;

import com.example.lab3miercoles.entity.AutosEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
public class VistasController {

    public ArrayList<AutosEntity> listaAutos = new ArrayList<>();
    //public AutosEntity auto1 = new AutosEntity(1, "toyota", "rojo", 10, 1, 10.1);
    public int contadorAutos=0;


    @GetMapping("/home")
    public String inicio(){
        return "home";
    }
    @GetMapping("/home/autos")
    public String irAutos(Model model){

        model.addAttribute("listaAutos",listaAutos);


        return "autosLista";
    }
    @GetMapping("/autos/agregar")
    public String irAutosForms(){
       return "autosForms";
    }
    @PostMapping("/autos/formPost")
    public String irAutosFormsPost(AutosEntity auto,Model model){
        contadorAutos+=1;
        auto.setId(contadorAutos);
        listaAutos.add(auto);


        model.addAttribute("listaAutos",listaAutos);
        return "autosLista";
    }

    @PostMapping("/autos/editarAuto")
    public String editarAuto(@RequestParam("idAutoLista") Integer id, Model model){
        System.out.println("id recibido: " + id);
        System.out.println("tamaño:" + listaAutos.size());;
        AutosEntity auto = listaAutos.get(id-1);
        System.out.println("auto a editar: " + auto.getId());
        model.addAttribute("auto",auto);
        return "editarAuto";
    }
    @PostMapping("/autos/editarAutoMandarLista")
    public String editarAutoMandarLista(AutosEntity auto, Model model){

        System.out.println("id a editar: " + auto.getId());
        listaAutos.get(auto.getId()-1).setColor(auto.getColor());
        listaAutos.get(auto.getId()-1).setModelo(auto.getModelo());
        listaAutos.get(auto.getId()-1).setKilometraje(auto.getKilometraje());
        listaAutos.get(auto.getId()-1).setCostoPorDia(auto.getCostoPorDia());

        model.addAttribute("listaAutos",listaAutos);
        return "autosLista";
    }
    @PostMapping("/autos/eliminarAuto")
    public String eliminar(@RequestParam("idAutoLista") Integer idAuto, Model model){
        listaAutos.remove(idAuto-1);

        model.addAttribute("listaAutos",listaAutos);
        return "autosLista";
    }



    @GetMapping("/home/sedes")
    public String irSedes(){
        return "sedeLista";
    }
    @GetMapping("/home/seguros")
    public String irSeguros(){
        return "seguroLista";
    }






}
