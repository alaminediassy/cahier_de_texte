package controller;

import dao.UtilisateurDAO;
import model.Utilisateur;


public class UtilisateurController {
    private final UtilisateurDAO utilisateurDAO = new UtilisateurDAO();

    /**
     * Méthode principale du service d'authentification
     * Ell vérifie si un utilisateur avec ce login et mot de passe existe
     * @param login
     * @param mot_de_passe
     * @return
     */
    public Utilisateur authentification(String login, String mot_de_passe) {
        // On délègue la recherche à UtilisateurDAO
        return utilisateurDAO.findByLoginAndPassword(login, mot_de_passe);
    }
}
