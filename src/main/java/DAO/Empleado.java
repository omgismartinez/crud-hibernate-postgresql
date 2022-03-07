/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Martinez
 */
@Entity(name="Empleado")
public class Empleado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clave")
    private long clave;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "telefono")
    private long telefono;
    
    // R e l a c i o n
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="clave")
//    private Departamento departamento;

//    public Departamento getDepartamento() {
//        return departamento;
//    }
//
//    public void setDepartamento(Departamento departamento) {
//        this.departamento = departamento;
//    }

    public Empleado(long clave, String nombre, String direccion, long telefono) {
        this.clave = clave;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    public Empleado(String nombre, String direccion, long telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Empleado() {
    }
    
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
}
