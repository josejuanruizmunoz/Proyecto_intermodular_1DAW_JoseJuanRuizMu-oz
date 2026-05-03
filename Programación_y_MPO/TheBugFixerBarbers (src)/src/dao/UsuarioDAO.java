package dao;

import utils.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public static String hacerLogin(String username, String password) {

        String sql = "SELECT rol FROM Usuarios WHERE username = ? AND password = ?";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {


            pstmt.setString(1, username);
            pstmt.setString(2, password);


            ResultSet rs = pstmt.executeQuery();


            if (rs.next()) {
                return rs.getString("rol"); // Nos devuelve 'ADMIN', 'CLIENTE' o 'BARBERO'
            }
        } catch (SQLException e) {
            System.out.println("❌ Error en la base de datos: " + e.getMessage());
        }


        return null;
    }
}