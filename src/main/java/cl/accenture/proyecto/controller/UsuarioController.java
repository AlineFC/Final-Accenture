package cl.accenture.proyecto.controller;
import cl.accenture.proyecto.model.Rol;
import cl.accenture.proyecto.model.Usuario;
import cl.accenture.proyecto.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin( value = "*")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    } //ksk


    @RequestMapping( method = RequestMethod.POST , path = "/loginUsuario")//funciona
    protected void login(@RequestBody Usuario usuario)  {
        String destino = "";
        usuario = usuarioService.validacionUsuario(usuario);

        switch(usuario.getMensaje()){
            case "Correcto":
                //map.addAttribute("email", email);
                destino = "Iniciando sesion...";
                break;
            case "contraseña":
                //map.addAttribute( "La contraseña es incorrecta.");
                destino = "La contraseña es incorrecta.";
                throw new RuntimeException("Usuario no encontrado");
            case "inexistente":
                //map.addAttribute( "El usuario no existe.");
                destino = "El email no se encuentra registrado en la base de datos.";
                throw new RuntimeException("Usuario no encontrado");
        }
    }
    @PutMapping("/agregarUsuario")//funciona
    protected String agregarUs(@RequestParam("email") String email, @RequestParam("contrasena") String contrasena, ModelMap map, @RequestParam ("nombre")String nombre,@RequestParam ("id_user") String idUser, @RequestParam ("id_rol")Rol rol ) {
        String destino = "";
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setContrasena(contrasena);
        usuario = usuarioService.validacionUsuario(usuario);
        if (true) {
            switch (usuario.getMensaje()) {
               case "Correcto":
                    map.addAttribute("email", email);
                    destino = "El email, y la contraseña ya se encuentran registrados en la base de datos.";
                    break;
                case "inexistente":
                    map.addAttribute( "El usuario no existe.");
                    destino = "Usuario creado";
                    Usuario us = new Usuario();
                    us.setIdUser(idUser);
                    us.setNombre(nombre);
                    us.setEmail(email);
                    us.setContrasena(contrasena);
                    us.setRol(rol);
                    usuarioService.guardarUsuario(us);
                    break;
            }
            return destino;
        }else{
            return "Problema con algun dato.";
        }
    }

    @PutMapping("/editarUsuario")//funcionaaaaaaaaaaaaaaaaaaaaaaaa
    public String editUser(@RequestParam("email") String email, @RequestParam("contrasena") String contrasena, ModelMap map, @RequestParam ("nombre")String nombre,@RequestParam ("id_user") String idUser, @RequestParam ("id_rol")Rol rol) {
        Usuario usuario = usuarioService.obtenerUsuario(idUser);
        Assert.notNull(usuario, "Usuario not found");
        usuario.setNombre(nombre);
        usuario.setContrasena(contrasena);
        usuario.setEmail(email);
        usuario.setRol(rol);
        usuario.setIdUser(idUser);
        usuarioService.guardarUsuario(usuario);
        return "que se guarde ";
    }

    @DeleteMapping("/eliminarUsuario") //funciona
    public boolean deleteUser(@RequestParam String idUser) {
        Usuario usuario = usuarioService.obtenerUsuario(idUser);
        System.out.println("Usuario DELETE" + usuario);
        usuarioService.eliminarUser(usuario);
        return true;
    }
    @RequestMapping("/obtenerUsuario/{id}") //funciona
    public Usuario obtenerPorId(@PathVariable(value="id") String id) {
        return usuarioService.obtenerUsuario(id); }

   @GetMapping("/encontrarEmail")//funciona
    public List<Usuario> encontrarEmail(@RequestParam String email){ //funciona
        List<Usuario> usuarios=usuarioService.obtenerEmail(email);
        return usuarios;
    }
    @GetMapping("/encontrarNombre")//funciona
    public List<Usuario> encontrarNombre(@RequestParam String nombre){ //funciona
        List<Usuario> usuarios=usuarioService.obtenerEmail(nombre);
        return usuarios;
    }
    @RequestMapping("/encontrarTodos") //funciona
    public  List<Usuario> encontrarTodos(){
        return usuarioService.encontrarTodos();
    }

}