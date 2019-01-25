/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.accenture.proyecto.model;

import javax.persistence.*;

/**
 *
 * @author CrateX
 */

@Entity
@Table(name = "usuarios")
public class Usuario {


    @Id
    @Column(name = "id_User")
    private String idUser;

    @Column(name="nombre")
    private String nombre;

    @Column(name="contrasena")
    private String contrasena;

    @Column(name="email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;
    private String mensaje;


    public Usuario() {
    }

    public Usuario(String idUser,String nombre,String contrasena,String email,Rol rol, String mensaje) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.email = email;
        this.rol = rol;
        this.mensaje=mensaje;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreUs) {
        this.nombre = nombreUs;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUser=" + idUser +
                ", nombre='" + nombre + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", email='" + email + '\'' +
                ", rol=" + rol +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}








