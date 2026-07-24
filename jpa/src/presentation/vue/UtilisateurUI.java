/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.vue;

import dao.GroupeDao;
import entite.Groupe;
import entite.Utilisateur;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
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
    private JComboBox<String> groupe;
    private JButton boutonEnregistrer;
    
    public UtilisateurUI(Utilisateur utilisateur) throws ObjetNonTrouveException{
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
    
    public final JPanel creerPanel() throws ObjetNonTrouveException{
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
        groupe = new JComboBox<>();
        listeGroupe() ;
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
            this.utilisateur.setId(Integer.parseInt(id.getText()));
        }
        
        this.utilisateur.setIdentifiant(identifiant.getText());
        this.utilisateur.setNom(nom.getText());
        this.utilisateur.setPrenom(prenom.getText());
        this.utilisateur.setMotDePasse(String.valueOf(mot_de_passe.getPassword()));
        this.utilisateur.setGroupe((Groupe) recupererGroupeViaNomSaisi());
    }
    
    public Utilisateur getUtilisateur(){
        return utilisateur;
    }
    
    public JButton getBoutonEnregistrer(){
        return boutonEnregistrer;
    }
    
    
    // Liste des  noms des groupes pour JComboBox
    public List<String> listeGroupe() throws ObjetNonTrouveException{
        List<String> listeNomGrp = new ArrayList<>();
        try {
            List<Groupe> listeGrp = new GroupeDao().listerGroupe();
            
            for(Groupe g : listeGrp){
                System.out.println(nom + " ");
                this.groupe.addItem(g.getNom());
            }
        } catch (Exception e) {
            throw e;
        }
        
        return listeNomGrp ;
    }
    
    // recuperer le groupe à partir du nom selectionner dans ComboBox
    public Groupe recupererGroupeViaNomSaisi(){
        Groupe u = null;
        try {
            GroupeDao dao = new GroupeDao();
            u = dao.trouverGroupe(groupe.getSelectedItem().toString());
        } catch (Exception ex) {
            Logger.getLogger(UtilisateurUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
}
