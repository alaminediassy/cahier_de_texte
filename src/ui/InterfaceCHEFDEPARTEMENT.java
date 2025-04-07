package ui;

import javax.swing.*;

public class InterfaceCHEFDEPARTEMENT extends JFrame {
    public InterfaceCHEFDEPARTEMENT() {
        setTitle("Authentification");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        add(new JLabel("Bienvenue chef de departement : ", SwingConstants.CENTER));
    }
}
