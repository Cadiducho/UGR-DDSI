package es.ugr.ddsi.model;

public class Material {
    
    private final Integer id;
    private final String nombre;

    public Material(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
