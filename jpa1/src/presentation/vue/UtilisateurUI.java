/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.vue;

import entite.Groupe;
import entite.Utilisateur;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import service.GroupeService;
import util.ObjetNonTrouveException;

/**
 *
 * @author jakk
 */
public class UtilisateurUI extends JFrame{
    private final Utilisateur utilisateur;
    private JTextField id;
    private JTextField nom;
    private JTextField prenom;
    private JTextField identifiant;
    private JPasswordField mot_de_passe;
    private JTextField groupe;
    private JButton boutonEnregistrer;
    
    public UtilisateurUI(Utilisateur utilisateur){
        String aide = """
                    Entrer les informations suivantes
                    Nom, prenom, identifiant, mot de passe, groupe => pour ajouterId,
                    Id, Nom, prenom, identifiant, mot de passe, groupe  => pour modifier,
                    Id => pour trouver ou supprimer,
                    Click sur "Enregistrer" => pour lister
                    """;
                    
        this.utilisateur = utilisateur;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(800, 600);
        JOptionPane.showMessageDialog(this, aide);
        this.add(creerPanel());
        this.setVisible(true);
    }
    
    public final JPanel creerPanel(){
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.ipadx = 10;
        gbc.ipady = 10;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Id"), gbc);
        gbc.gridx = 1;
        id = new JTextField(15);
        panel.add(id, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Nom"), gbc);
        gbc.gridx = 1;
        nom = new JTextField(15);
        panel.add(nom, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Prénom"), gbc);
        gbc.gridx = 1;
        prenom = new JTextField(15);
        panel.add(prenom, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Identifiant"), gbc);
        gbc.gridx = 1;
        identifiant = new JTextField(15);
        panel.add(identifiant, gbc); 
       
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Mot de passe"), gbc);
        gbc.gridx = 1;
        mot_de_passe = new JPasswordField(15);
        panel.add(mot_de_passe, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Groupe"), gbc);
        gbc.gridx = 1;
        groupe = new JTextField(15);
        panel.add(groupe, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        boutonEnregistrer = new JButton("Enregistrer");
        panel.add(boutonEnregistrer, gbc);
                
        
        return panel;
    }
    
    public void modifierUtilisateur() throws ObjetNonTrouveException{
        if(id.getText().trim().equals("") && identifiant.getText().trim().equals("")){
            throw new ObjetNonTrouveException("Aucun id/ Identifiant fourni");
        }
        
        if(!id.getText().trim().equals("")){
            try {
                this.utilisateur.setId(Integer.parseInt(id.getText()));
            } catch (NumberFormatException e) {
                throw new ObjetNonTrouveException(e.getMessage());
            }
        }
        
        this.utilisateur.setIdentifiant(identifiant.getText());
        this.utilisateur.setNom(nom.getText());
        this.utilisateur.setPrenom(prenom.getText());
        this.utilisateur.setMotDePasse(String.valueOf(mot_de_passe.getPassword()));
        this.utilisateur.setGroupe(recupererGroupeViaIdSaisi(Integer.parseInt(groupe.getText())));
    }
    
    public Utilisateur getUtilisateur(){
        return utilisateur;
    }
    
    public JButton getBoutonEnregistrer(){
        return boutonEnregistrer;
    }
    
    /*
        Vu que setGroupe à besoin d'une entité de classe Groupe or l'user ne nous fourni que l'id
        du groupe il nous faut cette méthode
        */
    public Groupe recupererGroupeViaIdSaisi(int id){
        Groupe u = null;
        try {
            GroupeService service = new GroupeService();
//            u = service.trouver(id);
        } catch (Exception ex) {
            Logger.getLogger(UtilisateurUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
}
