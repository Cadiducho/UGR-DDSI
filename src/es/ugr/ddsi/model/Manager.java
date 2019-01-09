package es.ugr.ddsi.model;

public class Manager {
    
    private final String id;
    private final String nombre;
    private final String email;
    private final String telefono;

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public Manager(String id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }
    
       @Override
    public String toString() {
        return nombre + ", (" + email + "), " + telefono;
    }
    
}
