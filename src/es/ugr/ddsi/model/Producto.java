package es.ugr.ddsi.model;

public class Producto {
    
    private final Integer id;
    private final String nombre;
    private final Integer coste;

    public Producto(Integer id, String nombre, Integer coste) {
        this.id = id;
        this.nombre = nombre;
        this.coste = coste;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCoste() {
        return coste;
    }

    @Override
    public String toString() {
        return nombre + ", " + coste + '€';
    }
    
    
}
