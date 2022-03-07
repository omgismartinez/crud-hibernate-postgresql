/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DAO.DAOempleado;
import DAO.Empleado;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martinez
 */
public class Principal {

    public Principal() {

        try {
            Scanner sn = new Scanner(System.in);
            boolean salir = false;
            int opcion = 0;

            Empleado e;
            DAOempleado daoE = new DAOempleado();

            while (!salir) {

                System.out.println("============== Menu ==============");
                System.out.println("1. Agregar");
                System.out.println("2. Actualizar");
                System.out.println("3. Eliminar");
                System.out.println("4. Listar");
                System.out.println("5. Salir");

                try {
                    long clave;
                    String nombre;
                    String direccion;
                    long telefono;

                    System.out.println("Elige una opcion: ");
                    opcion = sn.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.println("\nAgregar empleado");
                            System.out.println("Nombre: ");
                            nombre = sn.next();
                            System.out.println("Direccion: ");
                            direccion = sn.next();
                            System.out.println("Telefono: ");
                            telefono = sn.nextLong();
                            e = new Empleado(nombre, direccion, telefono);
                            daoE.agregar(e);
                            break;
                        case 2:
                            System.out.println("\nActualizar empleado");
                            System.out.println("Clave: ");
                            clave = sn.nextLong();
                            System.out.println("Nuevo nombre: ");
                            nombre = sn.next();
                            System.out.println("Nueva direccion: ");
                            direccion = sn.next();
                            System.out.println("Nuevo telefono: ");
                            telefono = sn.nextLong();
                            e = new Empleado(clave, nombre, direccion, telefono);
                            daoE.modificar(e);
                            break;
                        case 3:
                            System.out.println("\nEliminar empleado");
                            System.out.println("Clave: ");
                            clave = sn.nextLong();
                            daoE.eliminar(clave);
                            break;
                        case 4:
                            System.out.println("\nLista de empleados");
                            ;
                            List<Empleado> listaEmpleados = daoE.buscarTodos();
                            break;
                        case 5:
                            salir = true;
                            break;
                        default:
                            System.out.println("Solo numeros entre 1 y 5");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Debes elegir una opcion " + ex);
                }
            }
            sn.close();
        } catch (NumberFormatException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
    }
}
