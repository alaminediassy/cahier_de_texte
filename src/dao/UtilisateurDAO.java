package dao;

import model.Role;
import model.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurDAO {

    /**
     * Méthode qui permet de rechercher un utilisateur dans la base de données
     * à partir de son login et de son mot de passe
     * @param login
     * @param mot_de_passe
     * @return
     */
    public Utilisateur findByLoginAndPassword(String login, String mot_de_passe) {
        Utilisateur utilisateur = null;
        String sql = "SELECT * FROM utilisateurs WHERE login = ? AND mot_de_passe = ?";

        try (Connection newConnection = DatabaseConnection.getConnection();
            PreparedStatement statement = newConnection.prepareStatement(sql)) {

            statement.setString(1, login);
            statement.setString(2, mot_de_passe);

            ResultSet resultSet = statement.executeQuery();

            // Vérifie si le résultat correspond aux infos de l'utilisateur dans la BD
            if (resultSet.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(resultSet.getInt("ID"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setLogin(resultSet.getString("login"));
                utilisateur.setMotDePasse(resultSet.getString("mot_de_passe"));
                utilisateur.setRole(Role.valueOf(resultSet.getString("role")));
            }

        } catch (SQLException e) {
            System.out.println("Erreur de connexion" + e.getMessage());
        }

        return utilisateur;
    }
}
