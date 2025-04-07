package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Fournit la connexion à la base de données MYSQL
 */
public class DatabaseConnection {
    // URL de connexion à la base de donnée
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cahier_de_texte_1";

    // Identifiants de connexion à la base de données
    private static final String USER = "root";
    private static final String PASSWORD = "mamadou";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}
