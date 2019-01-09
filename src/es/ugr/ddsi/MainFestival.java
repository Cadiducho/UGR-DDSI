package es.ugr.ddsi;

import es.ugr.ddsi.interfaz.PanelCargando;
import es.ugr.ddsi.interfaz.MenuPrincipal;
import es.ugr.ddsi.model.Edicion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainFestival {
    
    public static void main(String[] args) {
        MainFestival main = new MainFestival();
        
        try {
            main.initialize();
        } catch (SQLException ex) {
            System.err.println("Ha ocurrido un error: ");
            System.err.println(ex.toString());
        }
    }
    
    private Connection connection;
    private Edicion edicionActual;

    public Edicion getEdicionActual() {
        return edicionActual;
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void initialize() throws SQLException {
        PanelCargando cargando = new PanelCargando();
        cargando.setVisible(true);
        System.out.println("Estableciendo conexión...");
        DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver());

        cargando.updateBar(20);
        connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle0.ugr.es:1521/practbd.oracle0.ugr.es",
            "x1957140", "x1957140");
        connection.setAutoCommit(false);
        
        cargando.updateBar(70);
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM edicion MINUS SELECT * FROM edicion WHERE rownum < (SELECT count(*) FROM edicion)");
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            edicionActual = new Edicion(rs.getInt("id_edicion"), rs.getInt("anio"));
        } else {
            System.err.println("No se ha conectado correctamente a la base datos!");
            return;
        }
        cargando.updateBar(90);
        
        java.awt.EventQueue.invokeLater(() -> {
            cargando.updateBar(100);
            new MenuPrincipal(this).setVisible(true);
            cargando.setVisible(false);
        });
    }
    
}
