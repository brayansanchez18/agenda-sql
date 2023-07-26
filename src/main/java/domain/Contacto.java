package domain;

public class Contacto {
    private int id;
    private String nombre;
    private String telefono;
    
    // sobre carga de constructores
    // crear un costructor para cada operacion que podamos o vallamos a realizar en la tabla

    // prodriamos tener la necesitad de crear objetos de tipo persona con el constructor vacio
    public Contacto() {
    }

    // proodiamos eliminar registros de la base de datos para lo cual solo necesitamos el id
    public Contacto(int id) {
        this.id = id;
    }

    // prodriamos insertar datos a la tabla por lo cual necesitariamos todos los campos de latabla menos el id
    // el id se omite porque es autoincrementable
    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // podriamos modificar un elemento de la tabla para lo cual podriamos ocupar cada uno de los campos de esta
    public Contacto(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    // constructor para filtrar contacto existente
    public Contacto(String telefono){
        this.telefono = telefono;
    }
    
//    public Contacto(String nombre){
//        this.nombre = nombre;
//    }
    
    // si necesitamos modificar un atributo de manera individual
    // debamos agregar los metodos get y set de cada atributo
    
    // GET & SET - ID
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    // GET & SET - NOMBRE
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    // GET & SET - TELEFONO
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    // TAMBIEN AGREGAR EL METODO TOSTRING
    //PARA OBTENER EL ESTADO DEL METODO EN CUALQUIER MOMENTO
    @Override
    public String toString() {
        return "Contacto{" + "idPersona=" + id+ "\n" +
                                        ", nombre=" + nombre + "\n" +
                                        ", telefono=" + telefono + '}' + "\n";
    }
}
