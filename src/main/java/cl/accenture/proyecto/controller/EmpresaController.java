package cl.accenture.proyecto.controller;


import cl.accenture.proyecto.model.Empresa;
import cl.accenture.proyecto.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @RequestMapping("/encontrarTodos") //funciona
    public  List<Empresa> encontrarTodos(){
        return empresaService.encontrarTodos();
    }


}
