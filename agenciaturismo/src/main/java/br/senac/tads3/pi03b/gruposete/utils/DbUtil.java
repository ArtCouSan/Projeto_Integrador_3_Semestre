package br.senac.tads3.pi03b.gruposete.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conn = null;

        // Passo 1: Registrar o driver JDBC
        Class.forName("com.mysql.jdbc.Driver");

        // Passo 2: Abrir a conexão
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sete?zeroDateTimeBehavior=convertToNull&useSSL=false",
                "root", // usuário BD
                "root"); // senha BD
        return conn;
    }
}
