package es.ugr.ddsi.model;

/**
 *
 * @author Dani
 */
public class Grupo {
    
    private final String id;
    private final String nombre;
    private final String email;
    private final String telefono;
    private final Integer cache;
    private final Integer id_edicion;

    public Grupo(String id, String nombre, String email, String telefono, Integer cache, Integer id_edicion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.cache = cache;
        this.id_edicion = id_edicion;
    }

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

    public Integer getCache() {
        return cache;
    }

    public Integer getId_edicion() {
        return id_edicion;
    }

    @Override
    public String toString() {
        return nombre + ", " + email + ", " + telefono + " Cache: " + cache + "€ en " + id_edicion;
    }
    
}
