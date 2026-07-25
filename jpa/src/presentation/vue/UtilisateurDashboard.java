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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import service.UtilisateurService;
import util.ObjetNonTrouveException;

/**
 *
 * @author jakk
 */
public class UtilisateurDashboard extends JPanel{
   private final DefaultTableModel model;
   private JTextField nom;
   private JTextField prenom;
   private JTextField identifiant;
   private JPasswordField mot_de_passe;
   private JComboBox<String> groupe;
   private JButton boutonEnregistrer;
   
   public UtilisateurDashboard() throws ObjetNonTrouveException{
       this.setLayout(new BorderLayout());
       
       //Table
       String[] columns = {"Id", "Nom", "Prenom", "Identifiant", "Mot de passe", "Groupe"};
       model = new DefaultTableModel(columns, 0);
       JTable table = new JTable(model);
       JScrollPane scroll = new JScrollPane(table);
       this.add(scroll, BorderLayout.CENTER);
       this.setVisible(true);
       
       // charger les données
       chargerUtilisateur();
       
       // Formulaire
       this.add(formPanel(), BorderLayout.WEST);
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
                   u.getGroupe()
               });
           }
       } catch (Exception ex) {
           Logger.getLogger(UtilisateurDashboard.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
    public final JPanel formPanel() throws ObjetNonTrouveException{
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
        listeGroupe() ;
        panel.add(groupe, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        boutonEnregistrer = new JButton("Enregistrer");
        panel.add(boutonEnregistrer, gbc);
                
        return panel;
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

}
