package cl.accenture.proyecto.model;


import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @Column(name = "idEmpresa")
    private String idEmpresa;
    @Column(name = "nombreEmpresa")
    private String nombreEmpresa;



    public Empresa(){

    }

    public Empresa(String idEmpresa, String nombreEmpresa, Proyecto proyecto ){
        this.idEmpresa=idEmpresa;
        this.nombreEmpresa=nombreEmpresa;

    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa=" + idEmpresa +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                '}';
    }
}
