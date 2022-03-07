/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Martinez
 */
@Entity(name = "Departamento")
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clave")
    private long clave;

    @Column(name = "nombre")
    private String nombre;
    
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "empleado", cascade = CascadeType.ALL)
//    Set emplado = new HashSet();

//    public Set getEmplado() {
//        return emplado;
//    }

//    public void setEmplado(Set emplado) {
//        this.emplado = emplado;
//    }

    public long getClave() {
        return clave;
    }

    public void setClave(long clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
