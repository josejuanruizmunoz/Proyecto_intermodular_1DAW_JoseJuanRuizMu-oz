package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:mariadb://localhost:3306/thebugfixerbarbers";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";

    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            return conexion;
        } catch (SQLException e) {
            System.out.println("❌ BUG CRÍTICO: No se pudo conectar a la base de datos.");
            System.out.println("Detalles: " + e.getMessage());
            return null;
        }
    }
}
