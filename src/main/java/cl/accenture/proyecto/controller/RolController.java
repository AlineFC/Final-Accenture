package cl.accenture.proyecto.controller;


import cl.accenture.proyecto.model.Rol;
import cl.accenture.proyecto.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administradores")
@CrossOrigin(value = "*")
public class RolController {

    private RolService rolService;

    @Autowired
    public RolController(RolService rolService){
        this.rolService=rolService;
    }

    @GetMapping("/administradores/{nombre}")
    public List<Rol> rolPorNombre(@RequestParam String nombre){
        return rolService.rolPorNombre(nombre);
    }

    @PutMapping("/agregarRol")//funciona
    protected String agregarRol(@RequestParam("idRol") String idRol,@RequestParam("nombre") String nombre,ModelMap map,@RequestParam ("descripcion") String descripcion) {
        String destino = "";
        Rol rol1 = new Rol();
        rol1.setIdRol(idRol);
        rol1.setNombre(nombre);
        rol1 = rolService.validacionRol(rol1);
        if (true) {
            switch (rol1.getDescripcion()) {
                case "Correcto":
                    map.addAttribute("idRol", idRol);
                    destino = "La persona ya se encuentra registrada en la base de datos como administrador.";
                    break;
                case "inexistente":
                    map.addAttribute( "El rol no existe.");
                    destino = "Rol creado";
                    Rol rl = new Rol();
                    rl.setIdRol(idRol);
                    rl.setNombre(nombre);
                    rl.setDescripcion(descripcion);
                    rolService.guardarRol(rl);
                    break;
            }
            return destino;
        }else{
            return "Problema con algun dato.";
        }
    }

    @DeleteMapping("/eliminarRol") //funciona
    public boolean deleteRol(@RequestParam String id) {
        Rol rol = rolService.rolPorId(id);
        System.out.println("Usuario DELETE" + rol);
        rolService.eliminarRol(rol);
        return true;
    }

    @RequestMapping("/obtenerRol/{id}") //funciona
    public Rol obtenerPorId(@PathVariable(value="id") String id) {
        return rolService.rolPorId(id); }

    @GetMapping("/encontrarNombre")//funciona
    public List<Rol> encontrarNombre(@RequestParam String nombre){ //funciona
        List<Rol> rols=rolService.rolPorNombre(nombre);
        return rols;
    }
    @RequestMapping("/encontrarTodos") //funciona
    public  List<Rol> encontrarTodos(){
        return rolService.encontrarTodos();
    }

}
