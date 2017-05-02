package br.senac.tads3.pi03b.gruposete.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbUtil {

    public static Connection getConnection()  {
        Connection conn = null;

        try {
            // Passo 1: Registrar o driver JDBC
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // Passo 2: Abrir a conexão
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/AGENCIA",
                    "root", // usuário BD
                    ""); // senha BD
        } catch (SQLException ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
