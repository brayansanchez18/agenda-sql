package DAO;

import static DAO.Conexion.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Contacto;

public class AgendaDAO {
    private static final String SQL_SELECT = "SELECT id, nombre, telefono FROM contactos";
    private static final String SQL_INSERT = "INSERT INTO contactos (nombre, telefono) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE contactos SET nombre = ?, telefono = ? where id = ?";
    private static final String SQL_DELETE = "DELETE FROM contactos WHERE id = ?";
    private static final String SQL_BUSCAR = "SELECT * FROM contactos WHERE telefono = ?";
    private static final String SQL_EXISTE_CONTACTO = "SELECT * FROM contactos WHERE nombre = ?";
//    private static final String SQL_SEARCH = "";


    // CREAMOS EL METODO READ
    static public List<Contacto> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Contacto contacto = null;
        List<Contacto> contactos = new ArrayList<>();
        
        try {
            conn = getConnection(); // establecemos conexion
            stmt = conn.prepareStatement(SQL_SELECT); // hacemos la consulta
            rs = stmt.executeQuery(); // ejecutamos el query sql
            
            // iteramos cada resultado y lo asignamos a la lista como un objeto de tipo persona
            while (rs.next()) {                
                // recupaamos columna x vaiable
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                
                // CREAMOS EL OBJETO DE TIPO PERSONA CON CADA UNA DE LAS VARIABLES
                contacto = new Contacto(id, nombre, telefono);
                // AGREGAMOS EL OBJETO A LA LISTA
                contactos.add(contacto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                // mandamos a cerar los objetos en caso de que esten abiertos
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return contactos;
    }


    // CREAMOS EL METODO CREATE
    public int insertar (Contacto contacto) { // como parametro le pasamos un objeto de tipo persona
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = getConnection(); // establecemos la conexion
            stmt = conn.prepareCall(SQL_INSERT); // llamamos a la sentencia sql a ejecutar
            // adignamos los valor a los parametros en la sentencia values
            stmt.setString(1, contacto.getNombre());
            stmt.setString(2, contacto.getTelefono());
            // ejecutamos la sentencia y esta nos debe retornar el numero de registros que fueron afectados
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        // retornamos los registros afectados
        return registros;
    }


    // CREAMOS EL METODO DE UPDATE
    public int actualizar (Contacto contacto) { // como parametro le pasamos un objeto de tipo persona
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = getConnection(); // establecemos la conexion
            stmt = conn.prepareCall(SQL_UPDATE); // llamamos a la sentencia sql a ejecutar
            // adignamos los valor a los parametros en la sentencia values
            stmt.setString(1, contacto.getNombre());
            stmt.setString(2, contacto.getTelefono());
            stmt.setInt(3, contacto.getId());
            // ejecutamos la sentencia y esta nos debe retornar el numero de registros que fueron afectados
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        // retornamos los registros afectados
        return registros;
    }

    // CREAMOS EL METODO DELETE
    public int eliminar (Contacto contacto) { // como parametro le pasamos un objeto de tipo persona
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = getConnection(); // establecemos la conexion
            stmt = conn.prepareCall(SQL_DELETE); // llamamos a la sentencia sql a ejecutar
            // adignamos los valor a los parametros en la sentencia values
            stmt.setInt(1, contacto.getId());
            // ejecutamos la sentencia y esta nos debe retornar el numero de registros que fueron afectados
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        // retornamos los registros afectados
        return registros;
    }

    // BUSCAMOS CONTACTO
    public List<Contacto> buscarContacto(Contacto telefonoContacto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Contacto contacto = null;
        List<Contacto> contactos = new ArrayList<>();
        
        try {
            conn = getConnection(); // establecemos conexion
            stmt = conn.prepareStatement(SQL_BUSCAR); // hacemos la consulta
            stmt.setString(1, telefonoContacto.getTelefono());
            rs = stmt.executeQuery(); // ejecutamos el query sql
            
            // iteramos cada resultado y lo asignamos a la lista como un objeto de tipo persona
            while (rs.next()) {                
                // recupaamos columna x vaiable
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                
                // CREAMOS EL OBJETO DE TIPO PERSONA CON CADA UNA DE LAS VARIABLES
                contacto = new Contacto(id, nombre, telefono);
                // AGREGAMOS EL OBJETO A LA LISTA
                contactos.add(contacto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                // mandamos a cerar los objetos en caso de que esten abiertos
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return contactos;
    }
    
    // FILTRAR NOMBRE REPETIDO
    public List<Contacto> FiltrarNombreRepetido(Contacto nombreContacto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Contacto contacto = null;
        List<Contacto> contactos = new ArrayList<>();
        
        try {
            conn = getConnection(); // establecemos conexion
            stmt = conn.prepareStatement(SQL_BUSCAR); // hacemos la consulta
            stmt.setString(1, nombreContacto.getNombre());
            rs = stmt.executeQuery(); // ejecutamos el query sql
            
            // iteramos cada resultado y lo asignamos a la lista como un objeto de tipo persona
            while (rs.next()) {                
                // recupaamos columna x vaiable
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                
                // CREAMOS EL OBJETO DE TIPO PERSONA CON CADA UNA DE LAS VARIABLES
                contacto = new Contacto(id, nombre, telefono);
                // AGREGAMOS EL OBJETO A LA LISTA
                contactos.add(contacto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                // mandamos a cerar los objetos en caso de que esten abiertos
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return contactos;
    }
}
