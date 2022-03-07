/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Martinez
 */
public class DAOempleado implements DAOgeneral<Empleado> {

    @Override
    public boolean agregar(Empleado pojo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(pojo);
            session.getTransaction().commit();
            System.out.println("Agregado!");
        } catch (Exception e) {
            System.out.println("No se pudo agregar");
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean eliminar(long id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            Empleado emp = (Empleado) session.load(Empleado.class, id);
            session.delete(emp);
            session.getTransaction().commit();
            System.out.println("Borrado!");
        } catch (HibernateException e) {
            System.out.println("No se pudo borrar");
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean modificar(Empleado pojo) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.update(pojo);
            session.getTransaction().commit();
            System.out.println("Modificado!");
        } catch (Exception e) {
            System.out.println("No se pudo modificar");
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public List<Empleado> buscarTodos() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Empleado> listaEmpleados = null;
        try {
            listaEmpleados = session.createQuery("from Empleado a").list();
            for (Empleado listaEmpleado : listaEmpleados) {
                System.out.println(
                        " Clave: " + listaEmpleado.getClave()
                        + " Nombre: " + listaEmpleado.getNombre()
                        + " Direccion: " + listaEmpleado.getDireccion()
                        + " Telefono: " + listaEmpleado.getTelefono()
                );
            }

            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("Algo salio mal " + e);
        } finally {
            session.close();
        }
        return listaEmpleados;
    }
}
