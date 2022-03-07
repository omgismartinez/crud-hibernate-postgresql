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
public class DAOdepartamento implements DAOgeneral<Departamento> {

    @Override
    public boolean agregar(Departamento pojo) {
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
            Departamento dep = (Departamento) session.load(Departamento.class, id);
            session.delete(dep);
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
    public boolean modificar(Departamento pojo) {
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
    public List<Departamento> buscarTodos() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Departamento> listaDepartamentos = null;
        try {
            listaDepartamentos = session.createQuery("from Departamento d").list();
            for (Departamento listaDepartamento : listaDepartamentos) {
                System.out.println(
                        " Clave: " + listaDepartamento.getClave()
                        + " Nombre: " + listaDepartamento.getNombre()
                );
            }

            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println("Algo salio mal " + e);
        } finally {
            session.close();
        }
        return listaDepartamentos;
    }

}
