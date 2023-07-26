package test;

import java.util.List;

import DAO.AgendaDAO;
import domain.Contacto;
import javax.swing.JOptionPane;

public class TestAgenda {

    static public void main(String[] args) {

        AgendaDAO agendaDAO = new AgendaDAO();
        
      
//        Agenda agenda = new Agenda();
//        agenda.mainMenu();

//        ====================================================================================================
    // INSERTANDO UN NUEVO OBJETO DE TIPO PERSONA
//        Contacto contactoNuevo = new Contacto("Ivett", "7779996633");
//        agendaDAO.insertar(contactoNuevo);
//        ====================================================================================================
    // ELIMINAR UN REGISTRO
//        Contacto contactoDelete = new Contacto(3);
//        agendaDAO.eliminar(contactoDelete);
//        ====================================================================================================
    // BUSCAR CONTACTO
//        Contacto cotnactoResultado = new Contacto("7295924900");
//        List<Contacto> contactos = agendaDAO.buscarContacto(cotnactoResultado);
//
//        contactos.forEach(contacto -> {
//            System.out.println("contacto = " + contacto);
//        });
//        ====================================================================================================
    // LISTAR PERSONAS
    // List<Contacto> contactos = AgendaDAO.seleccionar();
//        List<Contacto> contactos = agendaDAO.seleccionar();
//
//        contactos.forEach(contacto -> {
//            System.out.println("contacto = " + contacto);
//        });
//        
//        ====================================================================================================
    // BUSCAR CONTACTO
    Contacto cotnactoResultado = new Contacto("7295924900");
    List<Contacto> contactos = agendaDAO.buscarContacto(cotnactoResultado);

    if (contactos

    
        != null) {
            System.out.println("el contacto existe");
    }

    
        else {
            System.out.println("el contacto no existe");
    }

//        ====================================================================================================
//        1 - agregar contacto (insert) // listo solo poner joption pane
//        2 - existe contacto? (like, no te lo muestra solo te dice si existe)
//        4 - buscar contacto (like, busca y te muestra los detalles del contacto)\
//        5 - eliminar contacto (delete) // listo solo poner en un joption pane
//        0 - salir // listo
}
}
