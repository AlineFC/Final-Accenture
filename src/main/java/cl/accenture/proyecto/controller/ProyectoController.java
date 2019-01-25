package cl.accenture.proyecto.controller;

import cl.accenture.proyecto.model.*;
import cl.accenture.proyecto.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    private ProyectoService proyectoService;

    @Autowired
    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

/*
    @PutMapping("/agregarProyecto")//funciona
    protected String agregarProyecto(@RequestParam("idProyecto") String idProyecto, @RequestParam("nombre") String nombreProyecto, ModelMap map, @RequestParam Date fechaInicio, @RequestParam Date fechaTermino, @RequestParam ("idEmpresa")Empresa empresa ) {
        String destino = "";
        Proyecto proyecto = new Proyecto();
        proyecto.setIdProyecto(idProyecto);
        proyecto.setNombreProyecto(nombreProyecto);
        proyecto = (Proyecto) proyectoService.validacionProyecto(proyecto, idProyecto);
        if (true) {
            switch (proyecto.getMensaje()) {
                case "Correcto":
                    map.addAttribute("idProyecto", idProyecto);
                    destino = "El proyecto, y la contraseña ya se encuentran registrados en la base de datos.";
                    break;
                case "inexistente":
                    map.addAttribute( "El proyecto no existe.");
                    Proyecto pro = new Proyecto();
                    pro.setIdProyecto(idProyecto);
                    pro.setNombreProyecto(nombreProyecto);
                    pro.setFechaInicio(fechaInicio);
                    pro.setFechaTermino(fechaTermino);
                 //   pro.setStatus(status);
                    pro.setEmpresa(empresa);
                    proyectoService.guardarProyecto(pro);
                    destino = "Proyecto creado";
                    break;
            }
            return destino;
        }else{
            return "Problema con algun dato.";
        }
    }
    @PutMapping("/editarUsuario")//funcionaaaaaaaaaaaaaaaaaaaaaaaa
    public String editProyecto(ModelMap map,@RequestParam ("nombre")String nombre, @RequestParam ("fechaInicio") Date fechaInicio, @RequestParam ("fechaTermino") Date fechaTermino, @RequestParam ("idProyecto") String idProyecto, Proyecto proyecto, Empresa empresa) {
        proyecto.getIdProyecto(idProyecto);
        Assert.notNull(proyecto, "Proyecto not found");
        proyecto.setNombreProyecto(nombre);
        proyecto.setFechaInicio(fechaInicio);
        proyecto.setFechaTermino(fechaTermino);
        proyecto.setEmpresa(proyecto.getEmpresa());
        proyecto.setEmpresa(empresa);
        proyectoService.guardarProyecto(proyecto);
        return "Proyecto actualizado correctamente.";
    }
    @DeleteMapping("/eliminarProyecto") //funciona
    public boolean deleteProyecto(@RequestParam String idProyecto) {
        Proyecto proyecto = proyectoService.obtenerProyecto(idProyecto);
        System.out.println("SE ELIMINO" +proyecto);
        proyectoService.eliminarProyecto(proyecto);
        return true;
    }
    @RequestMapping("/obtenerUsuario/{id}") //funciona
    public Proyecto obtenerPorId(@PathVariable(value="id") String id) {
        return obtenerPorId(id); }


    @GetMapping("/encontrarNombre")//funciona
    public List<Proyecto> encontrarNombre(@RequestParam String nombre){ //funciona
        List<Proyecto> proyectos= encontrarNombre(nombre);
        return proyectos;
    }
    @RequestMapping("/encontrarTodos") //funciona
    public  List<Proyecto> encontrarTodos(){
        return proyectoService.encontrarTodos();
    }
}
*/
}