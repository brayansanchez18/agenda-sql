///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package test;
//
//import DAO.AgendaDAO;
//import domain.Contacto;
//import java.util.List;
//import javax.swing.JOptionPane;
//
///**
// *
// * @author KeiiKo
// */
//public class Agenda {
//
//    AgendaDAO agendaDAO = new AgendaDAO();
//
//    public void mainMenu() {
//        String menu = "Seleccione un elemento del menu: \n"
//                + "(1) agregar contacto\n"
//                + "(2) existe contacto\n"
//                + "(3) listar contactos\n"
//                + "(4) buscar contacto\n"
//                + "(5) eliminar contacto\n"
//                + "(6) Agenda llena?\n"
//                + "(7) espacios libres\n"
//                + "(0) salir";
//
//        try {
//            int seleccion = Integer.parseInt(
//                    JOptionPane.showInputDialog(null,
//                            menu,
//                            "menu principal",
//                            JOptionPane.QUESTION_MESSAGE));
//
//            switch (seleccion) {
//                case 1:
//
//                    // INSERTANDO UN NUEVO OBJETO DE TIPO PERSONA
//                    Contacto contactoNuevo = new Contacto("Ivett", "7779996633");
//                    agendaDAO.insertar(contactoNuevo);
//
//                    Contacto cotnactoResultado = new Contacto("victor");
////                    List<Contacto> contactos = agendaDAO.buscarContacto(cotnactoResultado);
//
//                    if (contactos
//                            != null) {
//                        JOptionPane.showMessageDialog(null, "el nombre del contacto ya existe en la agenda",
//                                "contacto preexistente", JOptionPane.PLAIN_MESSAGE);
//                    } else {
//                        String nombre = JOptionPane.showInputDialog(null, "ingrese el nombre del contacto", "nombre de contacto",
//                                JOptionPane.QUESTION_MESSAGE);
//                    }
//
//                    mainMenu();
//                    break;
//
//                case 3:
//// LISTAR PERSONAS
////                    List<Contacto> contactos = AgendaDAO.seleccionar();
//
////                    JOptionPane.showMessageDialog(null, "contacto = " + contactos);
////
////                    contactos.forEach(contacto -> {
////                        System.out.println("contacto = " + contacto);
////                    });
////                    mainMenu();
////                    break;
//
//                case 4:
//
//                    mainMenu();
//                    break;
//
//                case 6:
////          isFull();
//                    mainMenu();
//                    break;
//
//                case 7:
////          freeSlots();
//                    mainMenu();
//                    break;
//
//                case 0:
//                    JOptionPane.showMessageDialog(null, "gracias por usar su agenda", "adios", JOptionPane.PLAIN_MESSAGE);
//                    break;
//
//                default:
//                    JOptionPane.showMessageDialog(null, "intente de nuevo", "seleccion invalida", JOptionPane.PLAIN_MESSAGE);
//                    mainMenu();
//                    break;
//            }
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "intente de nuevo", "seleccion invalida", JOptionPane.PLAIN_MESSAGE);
//            mainMenu();
//        }
//    }
//}
