package es.ugr.ddsi;

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
    private Edicion edicionActual = new Edicion(2, 2018);

    public Edicion getEdicionActual() {
        return edicionActual;
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void initialize() throws SQLException {
        System.out.println("Estableciendo conexión...");
        DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver());

        connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle0.ugr.es:1521/practbd.oracle0.ugr.es",
            "x1957140", "x1957140");
        connection.setAutoCommit(false);

        PreparedStatement stmt = connection.prepareStatement("select 1 from edicion");
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            if (rs.getInt(1) != 1) {
                System.err.println("No se ha conectado correctamente a la base datos!");
                return;
            }
        }
        
        
    }
    
}
