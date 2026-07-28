/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation.vue;

import dao.GroupeDao;
import entite.Groupe;
import entite.Utilisateur;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import service.UtilisateurService;
import util.ObjetNonTrouveException;

/**
 *
 * @author jakk
 */
public class UtilisateurUI extends JPanel{
    private DefaultTableModel model;
    private final Utilisateur utilisateur;
    private JTextField nom;
    private JTextField prenom;
    private JTextField identifiant;
    private JPasswordField mot_de_passe;
    private JComboBox<String> groupe;
   
    public UtilisateurUI(Utilisateur utilisateur) throws ObjetNonTrouveException{
        this.utilisateur = utilisateur;
    }
    
    public JPanel chargerJTable() {
        JPanel p = new JPanel(new BorderLayout());

        String[] columns = {"Id", "Nom", "Prenom", "Identifiant", "Mot de passe", "Groupe"};

        model = new DefaultTableModel(columns, 0);

        JTable table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);

        p.add(scroll, BorderLayout.CENTER);

        try {
            chargerUtilisateur();
        } catch (ObjetNonTrouveException ex) {
            Logger.getLogger(UtilisateurUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }

    private void chargerUtilisateur() throws ObjetNonTrouveException{
        try {
            model.setRowCount(0);
            UtilisateurService service = new UtilisateurService();

            for (Utilisateur u : service.lister()){
                model.addRow(new Object[]{
                    u.getId(),
                    u.getNom(),
                    u.getPrenom(),
                    u.getIdentifiant(),
                    u.getMotDePasse(),
                    u.getGroupe().getNom()
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(UtilisateurUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public final JPanel creerFormulaire() throws ObjetNonTrouveException{
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridwidth = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.ipadx = 10;
        gbc.ipady = 10;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nom"), gbc);
        
        gbc.gridx = 1;
        nom = new JTextField(15);
        panel.add(nom, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Prénom"), gbc);
        gbc.gridx = 1;
        prenom = new JTextField(15);
        panel.add(prenom, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Identifiant"), gbc);
        gbc.gridx = 1;
        identifiant = new JTextField(15);
        panel.add(identifiant, gbc); 
       
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Mot de passe"), gbc);
        gbc.gridx = 1;
        mot_de_passe = new JPasswordField(15);
        panel.add(mot_de_passe, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Groupe"), gbc);
        gbc.gridx = 1;
        groupe = new JComboBox<>();
        remplirListeGroupe() ;
        panel.add(groupe, gbc);
        
        return panel;
    }
    
    public void remplirFormulaire(Utilisateur user){
        nom.setText(user.getNom());
        prenom.setText(user.getPrenom());
        identifiant.setText(user.getIdentifiant());
        mot_de_passe.setText(user.getMotDePasse());
        groupe.setSelectedItem(user.getGroupe().getNom());
    }
    
    public void viderFormulaire(){
        nom.setText("");
        prenom.setText("");
        identifiant.setText("");
        mot_de_passe.setText("");
    }
    
     public int recupererId(){
        while (true) {            
            try {
                String input = JOptionPane.showInputDialog(this, "Veuillez Renseigner l'Id: ");
                int parseInt = Integer.parseInt(input.trim());
                return parseInt;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Entrer un entier valide!");
            }
        }
    }
    
    public Utilisateur getUtilisateur(){
        return utilisateur;
    }
    
    public void modifierUtilisateur() throws ObjetNonTrouveException{
        if(nom.getText().trim().equals("") || identifiant.getText().trim().equals("")){
            throw new ObjetNonTrouveException("Nom et Identifiant requis");
        }
        
        utilisateur.setIdentifiant(identifiant.getText().trim());
        utilisateur.setNom(nom.getText().trim());
        utilisateur.setPrenom(prenom.getText().trim());
        utilisateur.setMotDePasse(String.valueOf(mot_de_passe.getPassword()));
        utilisateur.setGroupe((Groupe) recupererGroupeViaNomSaisi());
    }
    
    // Liste des  noms des groupes pour JComboBox
    public void remplirListeGroupe() throws ObjetNonTrouveException{
        try {
            List<Groupe> listeGrp = new GroupeDao().listerGroupe();
            
            for(Groupe g : listeGrp){
                this.groupe.addItem(g.getNom());
            }
        } catch (Exception e) {
            throw e;
        }
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