/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.vue;

import dao.GroupeDao;
import entite.Groupe;
import entite.Utilisateur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import util.ObjetNonTrouveException;

/**
 *
 * @author jakk
 */
public class UtilisateurUI extends JFrame{
    private Utilisateur utilisateur;
    private int id ;
    private JTextField nom;
    private JTextField prenom;
    private JTextField identifiant;
    private JPasswordField mot_de_passe;
    private JComboBox<String> groupe;
    private JButton boutonEnregistrer;
    private JTextArea output = new JTextArea("");  //Ecran
    private JButton ajouter;
    private JButton modifier;
    private JButton lister;
    private JButton supprimer;
    private JButton trouver;

        
    public UtilisateurUI() throws ObjetNonTrouveException{
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setTitle("Dashboard utilisateur");
        this.setSize(800, 600);
        this.add(creerFormulaire(), BorderLayout.WEST);
        this.add(creerEcran());
        this.setVisible(true);
    }
    
    public UtilisateurUI(Utilisateur utilisateur) throws ObjetNonTrouveException{
        this();
        this.utilisateur = new Utilisateur();
    }
    
    public final JPanel creerFormulaire() throws ObjetNonTrouveException{
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.ipadx = 10;
        gbc.ipady = 10;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nom et Identifiant obligatoires"), gbc);
        
        gbc.gridwidth = 1;
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
        remplirListeGroupe() ;
        panel.add(groupe, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        boutonEnregistrer = new JButton("Enregistrer");
        panel.add(boutonEnregistrer, gbc);
                
        return panel;
    }
    
    public final JPanel creerEcran(){
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.ipadx = 5;
        gbc.ipady = 5;
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Action sur utilisateur"), gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        ajouter = new JButton("Ajouter");
        inputPanel.add(ajouter, gbc);
        gbc.gridx = 1;
        trouver = new JButton("Trouver");
        inputPanel.add(trouver, gbc);
        gbc.gridx = 2;
        modifier = new JButton("Modifier");
        inputPanel.add(modifier, gbc);
        gbc.gridx = 3;
        supprimer = new JButton("Supprimer");
        inputPanel.add(supprimer, gbc);
        gbc.gridx = 4;
        lister = new JButton("Lister");
        inputPanel.add(lister, gbc);
        
        // Ecran de sortie
        output = new JTextArea(20, 20);
        output.setLineWrap(true);
        output.append("Les resultats s'afficheront ici...");
        JScrollPane sp = new JScrollPane(output);
        
        inputPanel.setBackground(Color.lightGray);
        panel.add(inputPanel, BorderLayout.SOUTH);
        panel.add(sp, BorderLayout.CENTER);
        panel.setVisible(true);
        
        return panel;
    }
    
    public void modifierUtilisateur() throws ObjetNonTrouveException{
        if(nom.getText().trim().equals("") || identifiant.getText().trim().equals("")){
            throw new ObjetNonTrouveException("Nom et Identifiant requis");
        }
        
        this.utilisateur.setIdentifiant(identifiant.getText().trim());
        this.utilisateur.setNom(nom.getText().trim());
        this.utilisateur.setPrenom(prenom.getText().trim());
        this.utilisateur.setMotDePasse(String.valueOf(mot_de_passe.getPassword()));
        this.utilisateur.setGroupe((Groupe) recupererGroupeViaNomSaisi());
    }
    
    public int recupererId(){
        while (true) {            
            try {
                String input = JOptionPane.showInputDialog(this, "Veuillez Renseigner l'Id: ");
                int parseInt = Integer.parseInt(input.trim());
                return parseInt;
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Entrer un entier valide!");
            }
        }
    }
    
    public Utilisateur getUtilisateur(){
        return utilisateur;
    }
    
    public JButton getBoutonEnregistrer(){
        return boutonEnregistrer;
    }
    
    public JButton getBoutonAjouter(){
        return ajouter;
    }
    
    public JButton getBoutonModifier(){
        return modifier;
    }
    
    public JButton getBoutonTrouver(){
        return trouver;
    }
    
    public JButton getBoutonSupprimer(){
        return supprimer;
    }
    
    public JButton getBoutonLister(){
        return lister;
    }
    
    public void viderFormulaire(){
        nom.setText("");
        prenom.setText("");
        identifiant.setText("");
        mot_de_passe.setText("");
    }
    
    public void afficherSurEcran(String affichage){
        output.setText(affichage);
    }
    
    // Liste des  noms des groupes pour JComboBox
    public List<String> remplirListeGroupe() throws ObjetNonTrouveException{
        List<String> listeNomGrp = new ArrayList<>();
        try {
            List<Groupe> listeGrp = new GroupeDao().listerGroupe();
            
            for(Groupe g : listeGrp){
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
