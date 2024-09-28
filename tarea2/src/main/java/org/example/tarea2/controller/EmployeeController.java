package org.example.tarea2.controller;

import org.example.tarea2.entity.Employees;
import org.example.tarea2.entity.Jobs;
import org.example.tarea2.repository.DepartmentsRepository;
import org.example.tarea2.repository.EmployeesRepository;
import org.example.tarea2.repository.JobsRepository;
import org.example.tarea2.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    JobsRepository jobsRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    DepartmentsRepository departmentsRepository;


    @GetMapping({"/employee/listaEmpleados","/employee",""})
    public String listaEmpleados(Model model){
        model.addAttribute("listaEmpleados",employeesRepository.findAll());
        return "lista";
    }

    @GetMapping({"/employee/editarEmpleado"})
    public String editarEmpelados(Model model,@RequestParam("id") Integer employeeId){
        Optional<Employees> employeesOpt = employeesRepository.findById(employeeId);
        if(employeesOpt.isPresent()) {
            Employees employee = employeesOpt.get();
            List<Jobs> listaJobs  = jobsRepository.findAll();
            model.addAttribute("employee",employee);
            model.addAttribute("listaJobs",listaJobs);
            return "infoEmpleado";
        }else{
            return "redirect:/employee";
        }

    }

    @PostMapping({"/employee/editar"})
    public String editar(Employees employee){
        System.out.println(employee.getEmployee_id());
        employeesRepository.save(employee);
        return  "redirect:/employee";
    }

    @GetMapping({"/employee/borrarEmpleado"})
    public String borrarEmpelados(Model model, @RequestParam("id") Integer employeeId, RedirectAttributes attr){

        try{
            employeesRepository.deleteById(employeeId);
            attr.addFlashAttribute("msg","si");
        }catch(Exception e){
            attr.addFlashAttribute("msg","no");
        }

        return "redirect:/employee";

    }
}
