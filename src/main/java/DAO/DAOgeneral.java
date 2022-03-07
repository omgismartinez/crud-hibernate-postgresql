package DAO;


import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Martinez
 * @param <T>
 */
public interface DAOgeneral<T> {

    public boolean agregar(T pojo);

    public boolean eliminar(long id);

    public boolean modificar(T pojo);

    public List<T> buscarTodos();
}
