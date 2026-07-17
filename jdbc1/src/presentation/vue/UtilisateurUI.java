/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.vue;

import entite.Utilisateur;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import service.UtilisateurService;

/**
 *
 * @author jakk
 */
public class UtilisateurUI extends JFrame {

    private final UtilisateurService service;
    private final Utilisateur utilisateur;
    private final JTextField identifiant;
    private final JPasswordField motDePasse;
    private final JButton boutonEnregistrer;

    public UtilisateurUI(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        service = new UtilisateurService();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(400, 300);
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        layout.setConstraints(this, c);

        identifiant = new JTextField(15);
        motDePasse = new JPasswordField(15);
        boutonEnregistrer = new JButton("Enregistrer");

        this.setLayout(layout);

        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);

        this.add(new JLabel("Identifiant : "), c);
        c.gridx = 1;
        this.add(identifiant, c);

        c.gridx = 0;
        c.gridy = 1;
        this.add(new JLabel("Mot de passe : "), c);
        c.gridx = 1;
        this.add(motDePasse, c);

        c.gridx = 1;
        c.gridy = 2;
        this.add(boutonEnregistrer, c);
        this.afficher();
    }
    public void modifierUtilisateur(){
        this.utilisateur.setIdentifiant(identifiant.getText());
        this.utilisateur.setMotDePasse(motDePasse.getText());
    }
    
    public Utilisateur getUtilisateur(){
        return utilisateur;
    }
    public JButton getBoutonEnregistrer(){
        return boutonEnregistrer;
    }
    private void afficher() {
        this.identifiant.setText(this.utilisateur.getIdentifiant());
    }
}