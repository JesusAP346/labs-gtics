package org.example.tarea3.controller;

import org.example.tarea3.entity.Departments;
import org.example.tarea3.entity.Employees;
import org.example.tarea3.entity.Jobs;
import org.example.tarea3.repository.DepartmentsRepository;
import org.example.tarea3.repository.EmployeesRepository;
import org.example.tarea3.repository.JobsRepository;
import org.example.tarea3.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/employees",method= RequestMethod.GET)
public class EmployeesController {
    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    DepartmentsRepository departmentsRepository;
    @Autowired
    JobsRepository jobsRepository;
    @Autowired
    LocationsRepository locationsRepository;

    @GetMapping("/crear")
    public String crearEmpleado(Model model){
        List<Employees> listaEmpleados = employeesRepository.findAll();
        List<Jobs> listaJobs = jobsRepository.findAll();
        List<Departments> listaDepartamentos = departmentsRepository.findAll();


        model.addAttribute("listaEmpleados",listaEmpleados);
        model.addAttribute("listaDepartamentos",listaDepartamentos);
        model.addAttribute("listaJobs",listaJobs);



        return "crearEmpleado";
    }




    @GetMapping({"/lista","/",""})
    public String mostrarLista(Model model){
        List<Employees> listaEmpleados = employeesRepository.findAll();


        model.addAttribute("listaEmpleados",listaEmpleados);
        return "listaEmpleados";
    }


    @GetMapping({"/editarEmpleado"})
    public String editarEmpleado(Model model, @RequestParam("id") Integer id){
        Optional<Employees> empleadoOpt = employeesRepository.findById(id);
        if(empleadoOpt.isPresent()){
            List<Employees> listaEmpleados = employeesRepository.findAll();
            List<Jobs> listaJobs = jobsRepository.findAll();
            List<Departments> listaDepartamentos = departmentsRepository.findAll();
            model.addAttribute("listaEmpleados",listaEmpleados);
            model.addAttribute("listaDepartamentos",listaDepartamentos);
            model.addAttribute("listaJobs",listaJobs);
            model.addAttribute("employee",empleadoOpt.get());
            return "editarEmpleado";
        }else{
            return "/employees/lista";
        }
    }

    @PostMapping("/crearPost")
    public String crearForm(Employees employee, RedirectAttributes attr){
        if(employee.getEmployee_id()==null){
            attr.addFlashAttribute("msg","Usuario creado exitosamente");
        }else{
            attr.addFlashAttribute("msg","Usuario actualizado exitosamente");
        }
        employeesRepository.save(employee);
        return "redirect:/employees/lista";
    }



    @GetMapping({"/borrarEmpleado"})
    public String borrarEmpleado(Model model, @RequestParam("id") Integer id, RedirectAttributes attr){
        try{
            employeesRepository.deleteById(id);
            attr.addFlashAttribute("msgborradoExito","empleado borrado exitosamente");
        }catch (Exception e){
            attr.addFlashAttribute("msgborradoFracaso","no se pudo borrar el empleado");
        }
        return "redirect:/employees";
    }
}
