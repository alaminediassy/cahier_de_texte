package ui;

import controller.UtilisateurController;
import model.Role;
import model.Utilisateur;

import javax.swing.*;
import java.awt.*;

public class ConnectionUI extends JFrame {
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public ConnectionUI() {
        setTitle("Authentification");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        loginField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Se connecter");

        setLayout(new GridLayout(4, 1, 10, 10));
        add(new JLabel("Login"));
        add(loginField);
        add(new JLabel("Mot de passe"));
        add(passwordField);
        add(loginButton);

        loginButton.addActionListener(e -> authentifier());
    }

    private void authentifier() {
        String login = loginField.getText();
        String password = new String(passwordField.getPassword());

        UtilisateurController utilisateurController = new UtilisateurController();
        Utilisateur user = utilisateurController.authentification(login, password);

        if (user != null) {
            JOptionPane.showMessageDialog(this, "Bienvenue " + user.getNom() );
            dispose();

            if (user.getRole() == Role.CHEF_DEPARTEMENT) {
                new InterfaceCHEFDEPARTEMENT().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Identifiants incorrects");
            }
        }

    }
}
