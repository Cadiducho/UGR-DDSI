package es.ugr.ddsi.model;

/**
 *
 * @author Dani
 */
public class Edicion {
    private final Integer id_edicion;
    private final Integer anio;

    public Integer getId_edicion() {
        return id_edicion;
    }

    public Integer getAnio() {
        return anio;
    }

    public Edicion(Integer id_edicion, Integer anio) {
        this.id_edicion = id_edicion;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Edicion{" + "id_edicion=" + id_edicion + ", anio=" + anio + '}';
    }
    
}
