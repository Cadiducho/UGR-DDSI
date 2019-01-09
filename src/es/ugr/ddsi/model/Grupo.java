package es.ugr.ddsi.model;

public class Grupo {
    
    private final String id;
    private final String nombre;
    private final String email;
    private final String telefono;
    private final Integer cache;

    public Grupo(String id, String nombre, String email, String telefono, Integer cache) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.cache = cache;
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
    
    @Override
    public String toString() {
        return nombre + ", " + email + ", " + telefono + ". Cache: " + cache + "€";
    }
    
}
