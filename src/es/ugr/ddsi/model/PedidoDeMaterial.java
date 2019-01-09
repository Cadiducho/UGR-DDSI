package es.ugr.ddsi.model;

public class PedidoDeMaterial {
    
    private final Integer id;

    public PedidoDeMaterial(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "Pedido de material " + id;
    }
    
}
