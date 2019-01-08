package es.ugr.ddsi.model;

public class Ubicacion {
    
    private final Integer id;
    private final String nombre;
    private final String nombre_oficial;
    private final String url;

    public Ubicacion(Integer id, String nombre, String nombre_oficial, String url) {
        this.id = id;
        this.nombre = nombre;
        this.nombre_oficial = nombre_oficial;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombre_oficial() {
        return nombre_oficial;
    }

    public String getUrl() {
        return url;
    }
    

}
